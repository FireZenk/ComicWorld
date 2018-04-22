package org.firezenk.comicworld.ui.features.comics.di

import dagger.Subcomponent
import org.firezenk.comicworld.di.ScreenScope
import org.firezenk.comicworld.ui.features.comics.ComicsScreen

@ScreenScope
@Subcomponent(modules = [ComicsModule::class])
interface ComicsComponent {
    infix fun inject(comicsScreen: ComicsScreen)
}