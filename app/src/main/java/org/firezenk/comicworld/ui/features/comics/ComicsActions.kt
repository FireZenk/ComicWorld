package org.firezenk.comicworld.ui.features.comics

import org.firezenk.comicworld.domain.usecases.GetComics
import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

class ComicsActions @Inject constructor(private val getComics: GetComics) : Action() {

    fun loadComics() = LoadComics(getComics)

    sealed class ComicsAction: Action() {

        class LoadComics(val getComics: GetComics) : ComicsAction()
    }
}

typealias Actions = ComicsActions.ComicsAction
typealias LoadComics = ComicsActions.ComicsAction.LoadComics