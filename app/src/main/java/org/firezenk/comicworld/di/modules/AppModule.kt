package org.firezenk.comicworld.di.modules

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides
import org.firezenk.comicworld.BuildConfig
import org.firezenk.kartographer.animations.ContextMonitor
import org.firezenk.kartographer.library.Kartographer
import javax.inject.Singleton

@Module open class AppModule(private val context: Context) {

    @Provides fun provideContext(): Context = context

    @Provides @Singleton fun provideKartographer(): Kartographer {
        val monitor = ContextMonitor()
        val app = context as Application
        app.registerActivityLifecycleCallbacks(monitor)
        return Kartographer(app, monitor).apply {
            if (BuildConfig.DEBUG) {
                debug()
            }
        }
    }

    @Provides @Singleton fun provideGlide(): RequestManager = Glide.with(context)
}