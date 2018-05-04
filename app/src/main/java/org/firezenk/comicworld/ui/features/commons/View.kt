package org.firezenk.comicworld.ui.features.commons

import android.arch.lifecycle.LifecycleObserver

interface View<in S : State>: LifecycleObserver {

    fun render(state: S)
}