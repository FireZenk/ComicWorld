package org.firezenk.comicworld

import android.app.Activity
import android.app.Application
import org.firezenk.comicworld.di.AppComponent
import org.firezenk.comicworld.di.DaggerAppComponent
import org.firezenk.comicworld.di.modules.AppModule
import org.firezenk.comicworld.di.modules.NetworkModule

class ComicWorldApp : Application() {

    companion object {
        lateinit var component: AppComponent
    }

    private lateinit var act: Activity

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
        component inject this
    }

    infix fun registerLauncher(activity: Activity) {
        act = activity
    }

    fun currentLauncher(): Activity = act
}