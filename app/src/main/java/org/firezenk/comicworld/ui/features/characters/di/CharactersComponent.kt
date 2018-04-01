package org.firezenk.comicworld.ui.features.characters.di

import dagger.Subcomponent
import org.firezenk.comicworld.di.ScreenScope
import org.firezenk.comicworld.ui.features.characters.CharactersScreen

@ScreenScope
@Subcomponent(modules = [CharactersModule::class])
interface CharactersComponent {
    infix fun inject(charactersScreen: CharactersScreen)
}