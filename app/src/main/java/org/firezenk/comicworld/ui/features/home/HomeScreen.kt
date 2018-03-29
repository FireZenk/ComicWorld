package org.firezenk.comicworld.ui.features.home

import android.content.Context
import android.support.design.widget.BottomNavigationView
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.screen_home.view.*
import org.firezenk.comicworld.ComicWorldApp.Companion.component
import org.firezenk.comicworld.R
import javax.inject.Inject

class HomeScreen @Inject constructor(context: Context) : RelativeLayout(context), HomeView {

    @Inject lateinit var presenter: HomePresenter
    @Inject lateinit var actions: HomeActions

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        inflate(context, R.layout.screen_home, this)

        component inject this

        presenter init this

        setupNavigation()
    }

    override fun render(state: HomeStates) = when(state) {
        is HomeStates.OpenHome -> message.text = state.message
        is HomeStates.OpenDashboard -> message.text = state.message
        is HomeStates.OpenNotifications -> message.text = state.message
        else -> {}
    }

    private fun setupNavigation() {
        navigation.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    presenter reduce GoHome()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    presenter reduce GoDashboard()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    presenter reduce GoNotifications()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })
    }
}