package org.firezenk.comicworld.ui.features.home

import org.firezenk.comicworld.ui.features.commons.Presenter
import org.firezenk.kartographer.library.Kartographer
import javax.inject.Inject

class HomePresenter @Inject constructor(router: Kartographer, private val mapper: HomeMapper)
    : Presenter<HomeActions, HomeStates, HomeView>(router) {

    override fun reduce(action: HomeActions) {
        when(action) {
            is GoHome -> render(mapper.home())
            is GoDashboard -> render(mapper.dashboard())
            is GoNotifications -> render(mapper.notifications())
            else -> super.reduce(action)
        }
    }
}