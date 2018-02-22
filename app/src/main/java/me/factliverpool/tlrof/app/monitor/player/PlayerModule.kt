package me.factliverpool.tlrof.app.monitor.player

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import me.factliverpool.tlrof.injection.ViewModelKey

@Module
internal abstract class PlayerModule {

    @ContributesAndroidInjector
    internal abstract fun homeBattleFragment(): PlayerFragment

    @Binds
    @IntoMap
    @ViewModelKey(PlayerViewModel::class)
    abstract fun bindMainViewModel(viewModel: PlayerViewModel): ViewModel
}