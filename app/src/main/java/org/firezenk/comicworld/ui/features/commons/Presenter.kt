package org.firezenk.comicworld.ui.features.commons

import org.firezenk.kartographer.library.Kartographer

abstract class Presenter<in A : Action, in S : State, in V : Screen<S>>(internal val router: Kartographer) {

    private lateinit var screen: V

    open infix fun init(screen: V) {
        this.screen = screen
    }

    abstract infix fun reduce(action: A)

    infix fun render(state: S) = screen.render(state)
}