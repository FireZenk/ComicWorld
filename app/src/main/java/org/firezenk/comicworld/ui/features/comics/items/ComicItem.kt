package org.firezenk.comicworld.ui.features.comics.items

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import kotlinx.android.synthetic.main.screen_characters_item.view.*
import org.firezenk.comicworld.R
import org.firezenk.comicworld.domain.models.ComicModel
import org.firezenk.comicworld.ui.extensions.BindableView
import org.firezenk.comicworld.ui.extensions.GlideApp

class ComicItem constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr), BindableView<ComicModel> {

    private lateinit var model: ComicModel

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        inflate(context, R.layout.screen_comics_item, this)

        name.text = model.title
        description.text = model.description

        GlideApp.with(this).load(model.coverUrl).into(avatar);
    }

    override fun bind(model: ComicModel) {
        this.model = model
    }
}