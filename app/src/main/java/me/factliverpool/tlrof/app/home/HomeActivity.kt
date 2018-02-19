package me.factliverpool.tlrof.app.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.google.firebase.auth.FirebaseAuth
import me.factliverpool.tlrof.R
import me.factliverpool.tlrof.app.home.homebattle.HomeFragment
import me.factliverpool.tlrof.custom.ViewPagerAdapter
import me.factliverpool.tlrof.custom.base.BaseActivity
import me.factliverpool.tlrof.databinding.ActivityHomeBinding
import javax.inject.Inject



class HomeActivity : BaseActivity() {

    @Inject lateinit var homeFragment: HomeFragment
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        window.decorView.systemUiVisibility = uiOptions
        val adapter = ViewPagerAdapter(supportFragmentManager,
                arrayListOf(homeFragment))
        binding.homeViewPager.adapter = adapter

        FirebaseAuth.getInstance().signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Firebase Auth", "signInWithCustomToken:success")
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Firebase Auth", "signInWithCustomToken:failure", task.exception)
                    }
                }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}