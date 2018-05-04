package org.firezenk.comicworld.ui.features.commons

import org.firezenk.kartographer.library.Kartographer

abstract class Presenter<in A : Action, S : State>(internal val router: Kartographer) {

    private lateinit var screen: Screen<S>

    open infix fun init(screen: Screen<S>) {
        this.screen = screen
    }

    abstract infix fun reduce(action: A)

    infix fun render(state: S) = screen.render(state)
}