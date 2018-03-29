package org.firezenk.comicworld.ui.features.home

import org.firezenk.comicworld.domain.usecases.GetCharacters
import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

open class HomeActions @Inject constructor(open val getCharacters: GetCharacters) : Action() {

    fun home() = GoHome(getCharacters)

    fun dashboard() = GoDashboard(getCharacters)

    fun notifications() = GoNotifications(getCharacters)

    class GoHome(override val getCharacters: GetCharacters) : HomeActions(getCharacters)

    class GoDashboard(override val getCharacters: GetCharacters) : HomeActions(getCharacters)

    class GoNotifications(override val getCharacters: GetCharacters) : HomeActions(getCharacters)
}