package org.firezenk.comicworld.ui.features.home

import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

open class HomeActions @Inject constructor() : Action() {

    fun home() = GoHome()

    fun dashboard() = GoDashboard()

    fun notifications() = GoNotifications()

    class GoHome : HomeActions()

    class GoDashboard : HomeActions()

    class GoNotifications : HomeActions()
}