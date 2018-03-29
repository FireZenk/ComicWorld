package org.firezenk.comicworld.di

import dagger.Component
import org.firezenk.comicworld.ComicWorldApp
import org.firezenk.comicworld.di.modules.AppModule
import org.firezenk.comicworld.ui.features.home.HomeActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    infix fun inject(app: ComicWorldApp)
    infix fun inject(homeActivity: HomeActivity)
}