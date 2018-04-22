package org.firezenk.comicworld.ui.features.comics.di

import android.view.ViewGroup
import dagger.Module
import org.firezenk.comicworld.di.modules.ScreenModule

@Module
class ComicsModule(private val container: ViewGroup) : ScreenModule(container)