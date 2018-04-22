package org.firezenk.comicworld.ui.features.character.di

import dagger.Subcomponent
import org.firezenk.comicworld.di.ScreenScope
import org.firezenk.comicworld.ui.features.character.CharacterScreen

@ScreenScope
@Subcomponent(modules = [CharacterModule::class])
interface CharacterComponent {
    infix fun inject(characterScreen: CharacterScreen)
}