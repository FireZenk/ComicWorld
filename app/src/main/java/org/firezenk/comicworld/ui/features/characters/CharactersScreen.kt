package org.firezenk.comicworld.ui.features.characters

import android.content.Context
import android.widget.RelativeLayout
import javax.inject.Inject

class CharactersScreen @Inject constructor(context: Context) : RelativeLayout(context), CharactersView {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        // TODO do things here
    }

    override fun render(state: CharactersStates) {
        // TODO do things here
    }
}