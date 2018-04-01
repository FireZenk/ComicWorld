package org.firezenk.comicworld.ui.features.comics

import org.firezenk.comicworld.domain.models.ComicModel
import org.firezenk.comicworld.ui.features.commons.State
import javax.inject.Inject

open class ComicsStates @Inject constructor() : State() {

    fun success(list: List<ComicModel>) = Success(list)

    data class Success(val list: List<ComicModel>) : ComicsStates()
}