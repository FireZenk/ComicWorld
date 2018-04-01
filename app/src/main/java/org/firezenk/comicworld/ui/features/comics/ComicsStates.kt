package org.firezenk.comicworld.ui.features.comics

import android.content.Context
import org.firezenk.comicworld.R
import org.firezenk.comicworld.domain.models.ComicModel
import org.firezenk.comicworld.ui.features.commons.State
import javax.inject.Inject

open class ComicsStates @Inject constructor(private val context: Context) : State() {

    fun success(list: List<ComicModel>) = Success(context, list.map {
        if (it.description.isNullOrBlank()) {
            it.copy(description = context.getString(R.string.no_description))
        } else {
            it
        }
    })

    data class Success(private val context: Context, val list: List<ComicModel>) : ComicsStates(context)
}