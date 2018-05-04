package org.firezenk.comicworld.ui.features.home

import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

open class HomeActions @Inject constructor() : Action() {

    fun home() = GoHome()

    fun dashboard() = GoDashboard()

    fun notifications() = GoNotifications()

    sealed class HomeAction : Action() {

        class GoHome : HomeAction()
        class GoDashboard : HomeAction()
        class GoNotifications : HomeAction()
    }
}

typealias Actions = HomeActions.HomeAction
typealias GoHome = HomeActions.HomeAction.GoHome
typealias GoDashboard = HomeActions.HomeAction.GoDashboard
typealias GoNotifications = HomeActions.HomeAction.GoNotifications