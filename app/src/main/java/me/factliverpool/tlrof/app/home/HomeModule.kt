package me.factliverpool.tlrof.app.home

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.factliverpool.tlrof.app.home.homebattle.HomeSubModule

@Module
internal abstract class HomeModule {

    @ContributesAndroidInjector(modules = [HomeSubModule::class])
    internal abstract fun homeActivity(): HomeActivity

}