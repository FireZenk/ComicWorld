package org.firezenk.comicworld.di

import dagger.Component
import org.firezenk.comicworld.ComicWorldApp
import org.firezenk.comicworld.di.modules.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    infix fun inject(app: ComicWorldApp)
}