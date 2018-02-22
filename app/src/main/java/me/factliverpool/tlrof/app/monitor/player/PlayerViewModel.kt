package me.factliverpool.tlrof.app.monitor.player

import android.arch.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import me.factliverpool.tlrof.androidmanagers.PreferencesManager
import me.factliverpool.tlrof.app.monitor.PlayerActions
import me.factliverpool.tlrof.custom.baselca.BaseViewModel
import javax.inject.Inject

/**
 * Created by Mladen Rakonjac on 8/26/17.
 */
internal class PlayerViewModel @Inject constructor(val fbDbRef: DatabaseReference,
                                                   private val preferencesManager: PreferencesManager)
    : BaseViewModel() {

    var clockState = MutableLiveData<Boolean>()
    private var isItFirstTime = true

    private val valueEventListener: ValueEventListener
        get() {
            return object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {

                    p0?.let {
                        if(isItFirstTime){
                            isItFirstTime = false
                            return
                        }

                        val value = it.getValue(PlayerActions::class.java)
                        clockState.value =  value?.enjoydring

                    }

                }

            }
        }


    fun startListeningForInvitations() {
        val value1: ValueEventListener = valueEventListener
        fbDbRef.addValueEventListener(value1)
    }

    override fun onCleared() {
        fbDbRef.removeEventListener(valueEventListener)
        super.onCleared()

    }

}