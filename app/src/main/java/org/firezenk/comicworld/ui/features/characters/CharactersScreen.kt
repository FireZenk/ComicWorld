package org.firezenk.comicworld.ui.features.characters

import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.include_toolbar.view.*
import kotlinx.android.synthetic.main.screen_characters.view.*
import org.firezenk.comicworld.ComicWorldApp
import org.firezenk.comicworld.ComicWorldApp.Companion.component
import org.firezenk.comicworld.R
import org.firezenk.comicworld.domain.models.CharacterModel
import org.firezenk.comicworld.ui.extensions.DSLAdapter
import org.firezenk.comicworld.ui.extensions.adapterDSL
import org.firezenk.comicworld.ui.extensions.dsl
import org.firezenk.comicworld.ui.extensions.toast
import org.firezenk.comicworld.ui.features.characters.di.CharactersModule
import org.firezenk.comicworld.ui.features.characters.items.CharacterItem
import org.firezenk.kartographer.annotations.RoutableView
import javax.inject.Inject

@RoutableView
class CharactersScreen @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : LinearLayout(context, attrs, defStyleAttr), CharactersView, LifecycleObserver {

    @Inject lateinit var lifecycle: Lifecycle
    @Inject lateinit var presenter: CharactersPresenter
    @Inject lateinit var actions: CharactersActions

    private val adapter: DSLAdapter<CharacterModel> by lazy {
        adapterDSL<CharacterModel> {
            itemView = {
                CharacterItem(it).apply {
                    click { id -> presenter reduce actions.openCharacter(id) }
                }
            }
            comparator = compareBy {
                it.id
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        inflate(context, R.layout.screen_characters, this)

        component add CharactersModule(parent as ViewGroup) inject this

        lifecycle.addObserver(this)

        list.adapter = adapter

        toolbar.dsl {
            title = R.string.app_name
            back {
                action = {
                    toast(R.string.toast_home_clicked) 
                }
            }
            menu = R.menu.menu_characters
            +item {
                id = R.id.characters_refresh
                action = {
                    presenter reduce actions.loadCharacters()
                }
            }
            +item {
                id = R.id.characters_exit
                action = {
                    (context as Activity).finish()
                }
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        presenter.run {
            this init this@CharactersScreen
            this reduce actions.loadCharacters()
        }
    }

    override fun render(state: CharactersStates) = when(state) {
        is CharactersStates.Success -> adapter.addAll(state.list)
        else -> { }
    }
}