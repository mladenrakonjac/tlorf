package me.factliverpool.tlrof.custom.baselca

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by mladenrakonjac on 26/12/2017.
 */
open class BaseViewModel : ViewModel() {
    internal val compositeDisposable = CompositeDisposable()
    val isNoInternetConnection = MutableLiveData<Boolean>()
    val isFinishScreenOnNoInternetConnection = MutableLiveData<Boolean>()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}