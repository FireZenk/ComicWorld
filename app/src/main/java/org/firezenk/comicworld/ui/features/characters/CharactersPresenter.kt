package org.firezenk.comicworld.ui.features.characters

import arrow.core.getOrDefault
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import org.firezenk.comicworld.ui.features.characters.di.CharactersModule.Companion.CHARACTERS_ROUTE
import org.firezenk.comicworld.ui.features.commons.Presenter
import org.firezenk.kartographer.library.Kartographer
import org.firezenk.kartographer.library.types.ViewRoute
import javax.inject.Inject
import javax.inject.Named

class CharactersPresenter @Inject constructor(router: Kartographer,
                                              @Named(CHARACTERS_ROUTE) private val characterRoute: ViewRoute,
                                              private val states: CharactersStates)
    : Presenter<Actions, CharactersStates, CharactersView>(router) {

    override fun reduce(action: Actions) {
        when(action) {
            is LoadCharacters -> launch(UI) {
                action.getCharacters.execute().run {
                    render(states.success(getOrDefault { emptyList() }))
                }
            }
            is OpenCharacter -> {
                router.next(characterRoute, mapOf("id" to action.id))
            }
        }
    }
}