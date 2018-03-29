package org.firezenk.comicworld.ui.features.characters

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.RelativeLayout
import org.firezenk.comicworld.ComicWorldApp.Companion.component
import javax.inject.Inject

class CharactersScreen @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr), CharactersView {

    @Inject lateinit var presenter: CharactersPresenter
    @Inject lateinit var actions: CharactersActions

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        component inject this

        presenter init this

        presenter reduce actions.getCharacters()
    }

    override fun render(state: CharactersStates) = when(state) {
        is CharactersStates.Success -> {
            state.list.forEach { Log.d("Hero", it.name) }
        }
        else -> { }
    }
}