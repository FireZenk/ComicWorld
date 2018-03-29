package org.firezenk.comicworld.ui.features.characters

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.screen_characters.view.*
import org.firezenk.comicworld.ComicWorldApp.Companion.component
import org.firezenk.comicworld.R
import javax.inject.Inject

class CharactersScreen @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : FrameLayout(context, attrs, defStyleAttr), CharactersView {

    @Inject lateinit var presenter: CharactersPresenter
    @Inject lateinit var actions: CharactersActions

    private val adapter: CharactersAdapter = CharactersAdapter()

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        inflate(context, R.layout.screen_characters, this)

        component inject this

        presenter init this

        list.adapter = adapter

        presenter reduce actions.getCharacters()
    }

    override fun render(state: CharactersStates) = when(state) {
        is CharactersStates.Success -> adapter.addAll(state.list)
        else -> { }
    }
}