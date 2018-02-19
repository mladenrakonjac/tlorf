package me.factliverpool.tlrof

import android.content.Context
import android.support.multidex.MultiDex
import com.crashlytics.android.Crashlytics
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.fabric.sdk.android.Fabric
import me.factliverpool.tlrof.app.DaggerAppComponent
import timber.log.Timber
import timber.log.Timber.DebugTree





/**
 * Created by mladenrakonjac on 02/10/17.
 */
class TlotfApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        Fabric.with(this, Crashlytics())
        //todo: this should be run only in debug mode
        Stetho.initializeWithDefaults(this)
        Timber.plant(DebugTree())


    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}