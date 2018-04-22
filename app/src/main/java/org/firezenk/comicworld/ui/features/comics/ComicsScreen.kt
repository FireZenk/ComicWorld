package org.firezenk.comicworld.ui.features.comics

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.screen_characters.view.*
import org.firezenk.comicworld.ComicWorldApp.Companion.component
import org.firezenk.comicworld.R
import org.firezenk.comicworld.domain.models.ComicModel
import org.firezenk.comicworld.ui.extensions.DSLAdapter
import org.firezenk.comicworld.ui.extensions.adapterDSL
import org.firezenk.comicworld.ui.features.comics.di.ComicsModule
import org.firezenk.comicworld.ui.features.comics.items.ComicItem
import org.firezenk.kartographer.annotations.RoutableView
import javax.inject.Inject

@RoutableView
class ComicsScreen @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : FrameLayout(context, attrs, defStyleAttr), ComicsView, LifecycleObserver {

    @Inject lateinit var lifecycle: Lifecycle
    @Inject lateinit var presenter: ComicsPresenter
    @Inject lateinit var actions: ComicsActions

    private val adapter: DSLAdapter<ComicModel> by lazy {
        adapterDSL<ComicModel> {
            itemView = {
                ComicItem(it)
            }
            comparator = compareBy {
                it.id
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        component add ComicsModule(this.parent as ViewGroup) inject this

        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        inflate(context, R.layout.screen_comics, this)
        list.adapter = adapter
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onStart() {
        presenter.run {
            this init this@ComicsScreen
            this reduce actions.loadComics()
        }
    }

    override fun render(state: ComicsStates) = when(state) {
        is ComicsStates.Success -> adapter.addAll(state.list)
        else -> { }
    }
}