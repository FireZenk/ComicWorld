package org.firezenk.comicworld.ui.features.characters.di

import android.view.ViewGroup
import dagger.Module
import dagger.Provides
import org.firezenk.comicworld.di.modules.ScreenModule
import org.firezenk.comicworld.ui.features.character.CharacterScreenRoute
import org.firezenk.kartographer.library.dsl.route
import org.firezenk.kartographer.library.types.Path
import org.firezenk.kartographer.library.types.ViewRoute
import javax.inject.Named

@Module
class CharactersModule(private val container: ViewGroup) : ScreenModule(container) {

    companion object {
        const val CHARACTER_ROUTE = "characters"
    }

    @Provides
    @Named(CHARACTER_ROUTE)
    fun provideCharactersRoute(): ViewRoute = route {
        target = CharacterScreenRoute()
        path = Path(CHARACTER_ROUTE)
        anchor = container
    }
}