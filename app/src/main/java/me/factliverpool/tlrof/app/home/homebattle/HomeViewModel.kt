package me.factliverpool.tlrof.app.home.homebattle

import android.databinding.ObservableField
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import me.factliverpool.tlrof.androidmanagers.PreferencesManager
import me.factliverpool.tlrof.app.home.RoomState
import me.factliverpool.tlrof.custom.baselca.BaseViewModel
import javax.inject.Inject

/**
 * Created by Mladen Rakonjac on 8/26/17.
 */
internal class HomeViewModel @Inject constructor(val fbDbRef: DatabaseReference,
                                                 private val preferencesManager: PreferencesManager) : BaseViewModel() {

    var clockState = ObservableField("no_state")
    var curtainState = ObservableField("no_state")
    var curtainPosition = ObservableField("no_state")
    var fragranceState = ObservableField("no_state")
    var glassOneState = ObservableField("no_state")
    var glassTwoState = ObservableField("no_state")
    var glassThreeState = ObservableField("no_state")
    var lightBriState = ObservableField("no_state")
    var lightColorMode = ObservableField("no_state")
    var lightCt = ObservableField("no_state")
    var lightEffect = ObservableField("no_state")
    var lightHue = ObservableField("no_state")
    var lightMode = ObservableField("no_state")
    var lightOn = ObservableField("no_state")
    var lightReachable = ObservableField("no_state")
    var lightSat = ObservableField("no_state")
    var lightX = ObservableField("no_state")
    var lightY = ObservableField("no_state")
    var printerState = ObservableField("no_state")
    var seatOneState = ObservableField("no_state")
    var seatTwoState = ObservableField("no_state")
    var seatThreeState = ObservableField("no_state")
    var uvLightsState = ObservableField("no_state")

    private val valueEventListener: ValueEventListener
        get() {
            return object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {

                    p0?.let {
                        val value = it.getValue(RoomState::class.java)
                        clockState.set( value?.clock?.state)
                        curtainState.set(value?.curtain?.state)
                        curtainPosition.set(value?.curtain?.position.toString())
                        fragranceState.set(value?.fragrance)
                        glassOneState.set(value?.glasses?.glass1)
                        glassTwoState.set(value?.glasses?.glass2)
                        glassThreeState.set(value?.glasses?.glass3)
                        lightBriState.set(value?.lights?.state?.bri.toString())
                        lightColorMode.set(value?.lights?.state?.colormode)
                        lightCt.set(value?.lights?.state?.ct.toString())
                        lightEffect.set(value?.lights?.state?.effect)
                        lightHue.set(value?.lights?.state?.hue.toString())
                        lightMode.set(value?.lights?.state?.mode)
                        lightOn.set(value?.lights?.state?.on.toString())
                        lightReachable.set(value?.lights?.state?.reachable.toString())
                        lightSat.set(value?.lights?.state?.sat.toString())
                        lightX.set(value?.lights?.state?.xy?.x.toString())
                        lightY.set(value?.lights?.state?.xy?.y.toString())
                        printerState.set(value?.printer?.state)
                        seatOneState.set(value?.seats?.seat1)
                        seatTwoState.set(value?.seats?.seat2)
                        seatThreeState.set(value?.seats?.seat3)
                        uvLightsState.set(value?.uvlight?.state)
                    }

                }

            }
        }


    fun startListeningForInvitations() {
        val value1: ValueEventListener = valueEventListener
        fbDbRef.addValueEventListener(value1)
        fbDbRef.child("fragrance").setValue("whatever")
    }

    fun openCurtains(position: Int) {
        fbDbRef.child("curatain").setValue(1)
    }

    override fun onCleared() {
        fbDbRef.removeEventListener(valueEventListener)
        super.onCleared()

    }

}