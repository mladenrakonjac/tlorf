package me.factliverpool.tlrof.app

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import me.factliverpool.tlrof.TlotfApp
import me.factliverpool.tlrof.app.home.HomeModule
import me.factliverpool.tlrof.injection.AppModule
import me.factliverpool.tlrof.injection.ViewModelBuilder
import javax.inject.Singleton

/**
 * Created by mladenrakonjac on 02/10/17.
 */

@Singleton
@Component(
        modules = [(AndroidSupportInjectionModule::class),
        (AppModule::class),
        (ViewModelBuilder::class),
        (HomeModule::class)])
interface AppComponent : AndroidInjector<TlotfApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<TlotfApp>()
}