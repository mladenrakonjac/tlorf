package me.factliverpool.tlrof.extensions

import android.databinding.BindingAdapter
import android.support.annotation.IdRes
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide


/**
 * Created by mladenrakonjac on 04/10/17.
 */
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view.context).load(url).into(view)
    }
}

@BindingAdapter("imageDrawable")
fun loadImageDrawable(view: ImageView, @IdRes drawable: Int?) {
    drawable?.let {
        Glide.with(view.context).load(drawable).into(view)
    }
}

@BindingAdapter("onOkInSoftKeyboard") // I like it to match the listener method name
fun setOnOkInSoftKeyboardListener(view: EditText,
                                  listener: OnOkInSoftKeyboardListener?) {
    if (listener == null) {
        view.setOnEditorActionListener(null)
    } else {
        view.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                listener.onOkInSoftKeyboard()
            }
            false
        }
    }
}



