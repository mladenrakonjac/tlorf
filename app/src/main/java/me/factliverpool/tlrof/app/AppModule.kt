package me.factliverpool.tlrof.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import me.factliverpool.tlrof.TlotfApp
import me.factliverpool.tlrof.androidmanagers.NetManager
import me.factliverpool.tlrof.networking.NetModule
import javax.inject.Singleton


/**
 * Created by mladenrakonjac on 02/10/17.
 */
@Module(includes = [(NetModule::class)])
class AppModule{

    @Provides
    fun providesContext(application: TlotfApp): Context {
        return application.applicationContext
    }

    @Provides @Singleton
    fun providesNetManager(applicationContext: TlotfApp): NetManager {
        return NetManager(applicationContext)
    }
}