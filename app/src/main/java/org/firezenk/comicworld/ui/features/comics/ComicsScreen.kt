package org.firezenk.comicworld.ui.features.comics

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.screen_characters.view.*
import org.firezenk.comicworld.ComicWorldApp.Companion.component
import org.firezenk.comicworld.R
import org.firezenk.comicworld.domain.models.ComicModel
import org.firezenk.comicworld.ui.extensions.DSLAdapter
import org.firezenk.comicworld.ui.extensions.adapterDSL
import org.firezenk.comicworld.ui.features.comics.items.ComicItem
import org.firezenk.kartographer.annotations.RoutableView
import javax.inject.Inject

@RoutableView
class ComicsScreen @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : FrameLayout(context, attrs, defStyleAttr), ComicsView {

    @Inject lateinit var presenter: ComicsPresenter
    @Inject lateinit var actions: ComicsActions

    private val adapter: DSLAdapter<ComicModel> by lazy {
        adapterDSL<ComicModel> {
            itemView = {
                ComicItem(context)
            }
            comparator = compareBy {
                it.id
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        inflate(context, R.layout.screen_characters, this)

        component inject this

        presenter init this

        list.adapter = adapter

        presenter reduce actions.loadComics()
    }

    override fun render(state: ComicsStates) = when(state) {
        is ComicsStates.Success -> adapter.addAll(state.list)
        else -> { }
    }
}