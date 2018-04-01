package org.firezenk.comicworld.ui.features.comics

import kotlinx.coroutines.experimental.runBlocking
import org.firezenk.comicworld.ui.features.commons.Presenter
import org.firezenk.kartographer.library.Kartographer
import javax.inject.Inject

class ComicsPresenter @Inject constructor(router: Kartographer, private val states: ComicsStates)
    : Presenter<ComicsActions, ComicsStates, ComicsView>(router) {

    override fun reduce(action: ComicsActions) = when(action) {
        is ComicsActions.LoadComics -> runBlocking {
            val heroes = action.getComics.execute()
            render(states.success(heroes.await()))
        }
        else -> super.reduce(action)
    }
}