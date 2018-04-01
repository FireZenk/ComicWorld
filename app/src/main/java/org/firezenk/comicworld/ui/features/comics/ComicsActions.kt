package org.firezenk.comicworld.ui.features.comics

import org.firezenk.comicworld.domain.usecases.GetComics
import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

open class ComicsActions @Inject constructor(open val getComics: GetComics) : Action() {

    fun loadComics() = LoadComics(getComics)

    class LoadComics(override val getComics: GetComics) : ComicsActions(getComics)
}