package org.firezenk.comicworld.ui.features

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.firezenk.comicworld.ComicWorldApp.Companion.component
import org.firezenk.comicworld.ui.features.home.HomeScreen

class Launcher : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component add this

        setContentView(HomeScreen(this))
    }
}
