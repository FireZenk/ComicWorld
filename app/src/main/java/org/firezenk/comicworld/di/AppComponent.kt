package org.firezenk.comicworld.di

import dagger.Component
import org.firezenk.comicworld.ComicWorldApp
import org.firezenk.comicworld.di.modules.AppModule
import org.firezenk.comicworld.di.modules.NetworkModule
import org.firezenk.comicworld.ui.features.Launcher
import org.firezenk.comicworld.ui.features.characters.CharactersScreen
import org.firezenk.comicworld.ui.features.comics.ComicsScreen
import org.firezenk.comicworld.ui.features.home.di.HomeComponent
import org.firezenk.comicworld.ui.features.home.di.HomeModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    infix fun inject(app: ComicWorldApp)

    infix fun add(launcher: Launcher)
    infix fun add(homeModule: HomeModule): HomeComponent

    infix fun inject(charactersScreen: CharactersScreen)
    infix fun inject(comicsScreen: ComicsScreen)
}