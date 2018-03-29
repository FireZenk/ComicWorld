package org.firezenk.comicworld

import android.app.Application
import org.firezenk.comicworld.di.DaggerAppComponent
import org.firezenk.comicworld.di.modules.AppModule

class ComicWorldApp : Application() {

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().appModule(AppModule(this)).build().inject(this)
    }
}