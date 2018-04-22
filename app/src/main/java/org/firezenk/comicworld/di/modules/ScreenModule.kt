package org.firezenk.comicworld.di.modules

import android.arch.lifecycle.Lifecycle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import dagger.Module
import dagger.Provides

@Module abstract class ScreenModule(private val container: ViewGroup) {

    @Provides fun providesLifecycle(): Lifecycle = (container.context as AppCompatActivity).lifecycle
}