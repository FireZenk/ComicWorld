package org.firezenk.comicworld.ui.features.character

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import org.firezenk.kartographer.annotations.RoutableView
import javax.inject.Inject

@RoutableView
class CharacterScreen @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : FrameLayout(context, attrs, defStyleAttr), CharacterView {

    @Inject lateinit var presenter: CharacterPresenter
    @Inject lateinit var actions: CharacterActions

    override fun render(state: CharacterStates) {

    }
}