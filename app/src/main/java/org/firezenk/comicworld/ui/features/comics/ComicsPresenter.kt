package org.firezenk.comicworld.ui.features.comics

import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import org.firezenk.comicworld.ui.features.commons.Presenter
import org.firezenk.kartographer.library.Kartographer
import javax.inject.Inject

class ComicsPresenter @Inject constructor(router: Kartographer, private val states: ComicsStates)
    : Presenter<ComicsActions, ComicsStates, ComicsView>(router) {

    override fun reduce(action: ComicsActions) {
        when(action) {
            is ComicsActions.LoadComics -> launch(UI) {
                action.getComics.execute().run {
                    render(states.success(this))
                }
            }
            else -> super.reduce(action)
        }
    }
}