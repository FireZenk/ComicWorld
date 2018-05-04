package org.firezenk.comicworld.ui.features.character

import android.app.Activity
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
import org.firezenk.comicworld.ui.extensions.toast
import org.firezenk.comicworld.ui.features.character.di.CharacterModule
import org.firezenk.kartographer.annotations.RoutableView
import javax.inject.Inject

@RoutableView
class CharacterScreen @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : LinearLayout(context, attrs, defStyleAttr), CharacterView {

    @Inject lateinit var lifecycle: Lifecycle
    @Inject lateinit var presenter: CharacterPresenter
    @Inject lateinit var actions: CharacterActions

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        inflate(context, R.layout.screen_character, this)

        component add CharacterModule(parent as ViewGroup) inject this

        lifecycle.addObserver(this)

        toolbar.dsl {
            back {
                action = { presenter reduce actions.back { (context as Activity).onBackPressed() } }
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        presenter.run {
            this init this@CharacterScreen
            this reduce actions.loadCharacter()
        }
    }

    override fun render(state: CharacterStates) {
        when(state) {
            is CharacterStates.Loaded -> {
                toolbar.dsl {
                    title = state.name
                }
            }
            is CharacterStates.Error -> {
                toast(R.string.error)
            }
        }
    }
}