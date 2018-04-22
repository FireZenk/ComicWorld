package org.firezenk.comicworld.ui.features.commons

import org.firezenk.kartographer.library.Kartographer

abstract class Presenter<in A : Action, in S : State, in V : View<S>>(internal val router: Kartographer) {

    private lateinit var view: V

    open infix fun init(view: V) {
        this.view = view
    }

    abstract infix fun reduce(action: A)

    infix fun render(state: S) = view.render(state)
}