package org.firezenk.comicworld.ui.features.character

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.include_toolbar.view.*
import org.firezenk.comicworld.ComicWorldApp.Companion.component
import org.firezenk.comicworld.R
import org.firezenk.comicworld.ui.extensions.dsl
import org.firezenk.comicworld.ui.features.character.di.CharacterModule
import org.firezenk.kartographer.annotations.RoutableView
import javax.inject.Inject

@RoutableView
class CharacterScreen @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : LinearLayout(context, attrs, defStyleAttr), CharacterView, LifecycleObserver {

    @Inject lateinit var lifecycle: Lifecycle
    @Inject lateinit var presenter: CharacterPresenter
    @Inject lateinit var actions: CharacterActions

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        component add CharacterModule(parent as ViewGroup) inject this

        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        inflate(context, R.layout.screen_character, this)
        toolbar.dsl {
            back {
                action = { presenter reduce actions.back() }
            }
        }
    }

    override fun render(state: CharacterStates) {

    }
}