package me.factliverpool.tlrof.custom.baselca

import android.arch.lifecycle.Observer
import android.widget.Toast
import dagger.android.support.DaggerFragment
import me.factliverpool.tlrof.custom.base.BaseActivity

/**
 * Created by mladenrakonjac on 26/12/2017.
 */
open class BaseFragment : DaggerFragment() {


    fun showNoInternetConnection(closeScreen: Boolean) {
        Toast.makeText(activity,"No internet Connection", Toast.LENGTH_LONG).show()

    }

    fun handleNoInternetConnection(baseViewModel: BaseViewModel) {
        baseViewModel.isNoInternetConnection.observe(this,
                Observer<Boolean> {
                    it?.let {
                        if (it) {
                            val isFinishOnClick = baseViewModel.isFinishScreenOnNoInternetConnection.value == true
                            if (isFinishOnClick) {
                                (activity as BaseActivity).isBackButtonAllowed = false
                            }
                            showNoInternetConnection(isFinishOnClick)

                        }
                    }
                })
    }

}