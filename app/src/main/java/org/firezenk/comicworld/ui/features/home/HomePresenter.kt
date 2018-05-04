package org.firezenk.comicworld.ui.features.home

import org.firezenk.comicworld.ui.features.commons.Presenter
import org.firezenk.comicworld.ui.features.home.di.HomeModule.Companion.CHARACTERS_ROUTE
import org.firezenk.comicworld.ui.features.home.di.HomeModule.Companion.COMICS_ROUTE
import org.firezenk.kartographer.library.Kartographer
import org.firezenk.kartographer.library.types.Route
import javax.inject.Inject
import javax.inject.Named

class HomePresenter @Inject constructor(router: Kartographer,
                                        @Named(CHARACTERS_ROUTE) private val charactersRoute: Route,
                                        @Named(COMICS_ROUTE) private val comicsRoute: Route,
                                        private val states: HomeStates)
    : Presenter<Actions, HomeStates, HomeView>(router) {

    override fun reduce(action: Actions) {
        when(action) {
            is GoHome -> router.next(charactersRoute)
            is GoDashboard -> router.next(comicsRoute)
            is GoNotifications -> render(states.notifications())
        }
    }
}