package org.firezenk.comicworld.ui.features.home

import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

open class HomeActions @Inject constructor() : Action()
class GoHome : HomeActions()
class GoDashboard : HomeActions()
class GoNotifications : HomeActions()