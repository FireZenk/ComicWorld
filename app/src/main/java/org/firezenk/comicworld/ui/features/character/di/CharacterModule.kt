package org.firezenk.comicworld.ui.features.character.di

import android.view.ViewGroup
import dagger.Module
import org.firezenk.comicworld.di.modules.ScreenModule

@Module
class CharacterModule(private val container: ViewGroup) : ScreenModule(container)