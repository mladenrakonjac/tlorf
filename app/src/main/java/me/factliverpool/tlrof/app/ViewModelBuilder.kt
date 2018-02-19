package me.factliverpool.tlrof.injection

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import me.banes.chris.tivi.inject.DaggerAwareViewModelFactory

/**
 * Created by mladenrakonjac on 02/10/17.
 */
@Module
internal abstract class ViewModelBuilder{

    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerAwareViewModelFactory) : ViewModelProvider.Factory
}