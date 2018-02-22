package me.factliverpool.tlrof.app.controller

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.factliverpool.tlrof.app.controller.devices.DevicesModule

@Module
internal abstract class ControllerModule {

    @ContributesAndroidInjector(modules = [DevicesModule::class])
    internal abstract fun homeActivity(): ControllerActivity

}