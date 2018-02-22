package me.factliverpool.tlrof.app.controller.devices

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import me.factliverpool.tlrof.injection.ViewModelKey

@Module
internal abstract class DevicesModule {

    @ContributesAndroidInjector
    internal abstract fun homeBattleFragment(): DevicesFragment

    @Binds
    @IntoMap
    @ViewModelKey(DevicesViewModel::class)
    abstract fun bindMainViewModel(viewModel: DevicesViewModel): ViewModel
}