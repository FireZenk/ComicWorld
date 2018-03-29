package org.firezenk.comicworld.ui.features.commons

import org.firezenk.kartographer.library.Kartographer

abstract class Presenter<in A : Action, in S : State, in V : View<S>>(internal val router: Kartographer) {

    private lateinit var view: V
    private lateinit var state: S
    private lateinit var action: A

    open infix fun init(view: V) {
        this.view = view
    }

    @Suppress("IMPLICIT_CAST_TO_ANY", "UNUSED_EXPRESSION")
    open infix fun reduce(action: A) = onLoad()

    protected open fun onLoad() {}

    infix fun render(state: S) = view.render(state)
}