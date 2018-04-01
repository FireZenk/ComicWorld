package org.firezenk.comicworld.ui.features.characters.items

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.screen_characters_item.view.*
import org.firezenk.comicworld.R
import org.firezenk.comicworld.domain.models.CharacterModel
import org.firezenk.comicworld.ui.extensions.BindableView
import org.firezenk.comicworld.ui.extensions.dsl

class CharacterItem constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr), BindableView<CharacterModel> {

    private lateinit var model: CharacterModel

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        inflate(context, R.layout.screen_characters_item, this)

        name.text = model.name
        description.text = model.description

        avatar.dsl {
            url = model.avatarUrl
            strategy = DiskCacheStrategy.ALL
        }
    }

    override fun bind(model: CharacterModel) {
        this.model = model
    }
}