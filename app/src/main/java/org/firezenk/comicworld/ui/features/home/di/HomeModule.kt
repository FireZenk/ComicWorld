package org.firezenk.comicworld.ui.features.home.di

import android.view.ViewGroup
import dagger.Module
import dagger.Provides
import org.firezenk.comicworld.di.modules.ScreenModule
import org.firezenk.comicworld.ui.features.characters.CharactersScreenRoute
import org.firezenk.kartographer.library.dsl.route
import org.firezenk.kartographer.library.types.Path
import org.firezenk.kartographer.library.types.Route
import javax.inject.Named

@Module
class HomeModule(private val container: ViewGroup) : ScreenModule() {

    companion object {
        const val CHARACTERS_ROUTE = "characters"
        const val COMICS_ROUTE = "comics"
        const val SERIES_ROUTE = "series"
    }

    @Provides
    @Named(CHARACTERS_ROUTE)
    fun provideCharactersRoute(): Route = route {
        target = CharactersScreenRoute()
        path = Path(CHARACTERS_ROUTE)
        anchor = container
    }
}