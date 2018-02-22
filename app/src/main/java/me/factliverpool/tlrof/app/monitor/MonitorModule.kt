package me.factliverpool.tlrof.app.monitor

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.factliverpool.tlrof.app.monitor.player.PlayerModule

@Module
internal abstract class MonitorModule {

    @ContributesAndroidInjector(modules = [PlayerModule::class])
    internal abstract fun monitorActivity(): MonitorActivity

}