package org.firezenk.comicworld.ui.features.home

import org.firezenk.comicworld.ui.features.commons.Presenter
import org.firezenk.comicworld.ui.features.home.di.HomeModule.Companion.CHARACTERS_ROUTE
import org.firezenk.kartographer.library.Kartographer
import org.firezenk.kartographer.library.types.Route
import javax.inject.Inject
import javax.inject.Named

class HomePresenter @Inject constructor(router: Kartographer,
                                        @Named(CHARACTERS_ROUTE) private val charactersRoute: Route,
                                        private val states: HomeStates)
    : Presenter<HomeActions, HomeStates, HomeView>(router) {

    override fun reduce(action: HomeActions) {
        when(action) {
            is HomeActions.GoHome -> router.next(charactersRoute)
            is HomeActions.GoDashboard -> render(states.dashboard())
            is HomeActions.GoNotifications -> render(states.notifications())
            else -> super.reduce(action)
        }
    }
}