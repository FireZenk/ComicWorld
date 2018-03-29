package org.firezenk.comicworld.ui.features.commons

interface View<in S : State> {

    fun render(state: S)
}