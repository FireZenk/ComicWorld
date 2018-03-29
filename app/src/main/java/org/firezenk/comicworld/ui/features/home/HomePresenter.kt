package org.firezenk.comicworld.ui.features.home

import org.firezenk.comicworld.ui.features.commons.Presenter
import org.firezenk.kartographer.library.Kartographer
import javax.inject.Inject

class HomePresenter @Inject constructor(router: Kartographer) : Presenter<HomeActions, HomeStates, HomeView>(router) {

    override fun reduce(action: HomeActions) {
        when(action) {
            // TODO more actions
            else -> super.reduce(action)
        }
    }
}