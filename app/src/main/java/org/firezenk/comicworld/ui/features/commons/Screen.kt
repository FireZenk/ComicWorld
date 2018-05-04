package org.firezenk.comicworld.ui.features.commons

import android.arch.lifecycle.LifecycleObserver

interface Screen<in S : State>: LifecycleObserver {

    fun render(state: S)
}