package org.firezenk.comicworld.ui.features.home.di

import dagger.Subcomponent
import org.firezenk.comicworld.di.ScreenScope
import org.firezenk.comicworld.ui.features.home.HomeScreen

@ScreenScope
@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {
    infix fun inject(homeScreen: HomeScreen)
}