package org.firezenk.comicworld.ui.features.characters

import kotlinx.coroutines.experimental.runBlocking
import org.firezenk.comicworld.ui.features.commons.Presenter
import org.firezenk.kartographer.library.Kartographer
import javax.inject.Inject

class CharactersPresenter @Inject constructor(router: Kartographer, private val states: CharactersStates)
    : Presenter<CharactersActions, CharactersStates, CharactersView>(router) {

    override fun reduce(action: CharactersActions) = when(action) {
        is CharactersActions.LoadCharacters -> runBlocking {
            val heroes = action.getCharacters.execute()
            render(states.success(heroes.await()))
        }
        else -> super.reduce(action)
    }
}