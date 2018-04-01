package org.firezenk.comicworld.ui.extensions

import android.widget.ImageView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.module.AppGlideModule

@DslMarker
annotation class ImageViewDsl

@ImageViewDsl
class ImageViewBuilder {

    lateinit var imageView: ImageView
    lateinit var url: String
    lateinit var strategy: DiskCacheStrategy

    fun build() {
        GlideApp.with(imageView.context)
                .load(url)
                .diskCacheStrategy(strategy)
                .into(imageView);
    }
}

fun ImageView.dsl(setup: ImageViewBuilder.() -> Unit) {
    with(ImageViewBuilder()) {
        imageView = this@dsl
        setup()
        build()
    }
}

@GlideModule
class ComicWorldGlide : AppGlideModule()