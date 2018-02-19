package me.factliverpool.tlrof.extensions

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import dagger.android.support.DaggerAppCompatActivity



/**
 * Created by mladenrakonjac on 04/10/17.
 */
inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun DaggerAppCompatActivity.addFragment(fragment: Fragment, frameId: Int){
    fragmentManager.inTransaction { add(frameId, fragment) }
}


fun DaggerAppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    fragmentManager.inTransaction{replace(frameId, fragment)}
}

fun View.setupUI(view: View, dummyFocusableView: View?) {

    // Set up touch listener for non-text box views to hide keyboard.
    if (view !is EditText) {
        view.setOnTouchListener { _, _ ->
            view.hideKeyboard()
            view.clearFocus()
            dummyFocusableView?.requestFocus()
            false
        }
    }

    //If a layout container, iterate over children and seed recursion.
    if (view is ViewGroup) {
        (0 until view.childCount)
                .map { view.getChildAt(it) }
                .forEach { setupUI(it, null) }
    }
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, 0)
}
