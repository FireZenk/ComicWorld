package org.firezenk.comicworld.ui.features.home

import org.firezenk.comicworld.domain.usecases.GetCharacters
import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

open class HomeActions @Inject constructor(private val getCharacters: GetCharacters) : Action() {

    fun home() = GoHome(getCharacters)

    fun dashboard() = GoDashboard(getCharacters)

    fun notifications() = GoNotifications(getCharacters)

    class GoHome(private val getCharacters: GetCharacters) : HomeActions(getCharacters) {

        fun execute() = getCharacters.execute()
    }

    class GoDashboard(private val getCharacters: GetCharacters) : HomeActions(getCharacters)

    class GoNotifications(private val getCharacters: GetCharacters) : HomeActions(getCharacters)
}