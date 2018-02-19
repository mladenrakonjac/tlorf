package me.factliverpool.tlrof.app.home.homebattle

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import me.factliverpool.tlrof.injection.ViewModelKey

@Module
internal abstract class HomeSubModule {

    @ContributesAndroidInjector
    internal abstract fun homeBattleFragment(): HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindMainViewModel(viewModel: HomeViewModel): ViewModel
}