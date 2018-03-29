package org.firezenk.comicworld.ui.features.home

import org.firezenk.comicworld.ui.features.commons.Presenter
import org.firezenk.kartographer.library.Kartographer
import javax.inject.Inject

class HomePresenter @Inject constructor(router: Kartographer, private val states: HomeStates)
    : Presenter<HomeActions, HomeStates, HomeView>(router) {

    override fun reduce(action: HomeActions) {
        when(action) {
            is HomeActions.GoHome -> render(states.home())
            is HomeActions.GoDashboard -> render(states.dashboard())
            is HomeActions.GoNotifications -> render(states.notifications())
        }
    }
}