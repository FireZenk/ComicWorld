package org.firezenk.comicworld.ui.features.home

import android.content.Context
import org.firezenk.comicworld.R
import org.firezenk.comicworld.domain.models.CharacterModel
import org.firezenk.comicworld.ui.features.commons.State
import javax.inject.Inject

open class HomeStates @Inject constructor(private val context: Context) : State() {

    fun home(list: List<CharacterModel>) = OpenHome(context, list)

    fun dashboard() = OpenDashboard(context)

    fun notifications() = OpenNotifications(context)

    data class OpenHome(private val context: Context, val list: List<CharacterModel>) : HomeStates(context)

    data class OpenDashboard(private val context: Context) : HomeStates(context) {
        val message: String
            get() = context.getString(R.string.title_dashboard)
    }

    data class OpenNotifications(private val context: Context) : HomeStates(context) {
        val message: String
            get() = context.getString(R.string.title_notifications)
    }
}