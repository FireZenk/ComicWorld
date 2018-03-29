package org.firezenk.comicworld.ui.features.home

import org.firezenk.comicworld.ui.features.commons.Action

sealed class HomeActions : Action()
class GoHome : HomeActions()
class GoDashboard : HomeActions()
class GoNotifications : HomeActions()