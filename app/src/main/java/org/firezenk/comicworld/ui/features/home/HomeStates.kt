package org.firezenk.comicworld.ui.features.home

import android.content.Context
import org.firezenk.comicworld.R
import org.firezenk.comicworld.ui.features.commons.State
import javax.inject.Inject

class HomeMapper @Inject constructor(private val context: Context) {

    fun home() = OpenHome(context.getString(R.string.title_home))
    fun dashboard() = OpenDashboard(context.getString(R.string.title_dashboard))
    fun notifications() = OpenNotifications(context.getString(R.string.title_notifications))
}

sealed class HomeStates : State()

data class OpenHome(val message: String) : HomeStates()
data class OpenDashboard(val message: String) : HomeStates()
data class OpenNotifications(val message: String) : HomeStates()