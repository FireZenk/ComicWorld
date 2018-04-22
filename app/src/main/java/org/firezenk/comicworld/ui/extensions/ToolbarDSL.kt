package org.firezenk.comicworld.ui.extensions

import android.support.v7.widget.Toolbar
import org.firezenk.comicworld.R

@DslMarker
annotation class ToolbarDsl

@ToolbarDsl
class ItemBuilder {

    lateinit var action: () -> Unit
    var id: Int = 0

    fun build() = id to action
}

@ToolbarDsl
class BackBuilder {
    var action: (() -> Unit)? = null
    var icon: Int = R.drawable.ic_home_black_24dp

    fun setup(toolbar: Toolbar) {
        action?.let { backAction ->
            toolbar.setNavigationIcon(icon)
            toolbar.setNavigationOnClickListener {
                backAction()
            }
        }
    }
}


@ToolbarDsl
class ToolbarBuilder {

    lateinit var toolbar: Toolbar
    lateinit var title: Any
    var back: BackBuilder? = null
    var menu: Int = 0
    var items = mutableListOf<Pair<Int, () -> Unit>>()

    fun build(): Toolbar {
        if (title != 0) {
            toolbar.title = when(title) {
                is Int -> toolbar.resources.getString(title as Int)
                is String -> title as String
                else -> {toolbar.resources.getString(R.string.app_name) }
            }
        }

        if (menu != 0) {
            toolbar.inflateMenu(menu)
        }

        back?.setup(toolbar)

        toolbar.setOnMenuItemClickListener {
            items.firstOrNull { item -> it.itemId == item.first }
                    ?.second
                    ?.invoke()
            true
        }

        return toolbar
    }

    fun item(id: Int = 0, setup: ItemBuilder.() -> Unit) {
        val builder = ItemBuilder()
        builder.id = id
        builder.setup()
        items.add(builder.build())
    }

    fun back(setup: BackBuilder.() -> Unit) {
        back = BackBuilder().apply(setup)
    }
}

@ToolbarDsl
fun toolbarDSL(setup: ToolbarBuilder.() -> Unit) {
    with(ToolbarBuilder()) {
        setup()
        build()
    }
}

fun Toolbar.dsl(setup: ToolbarBuilder.() -> Unit) {
    with(ToolbarBuilder()) {
        toolbar = this@dsl
        setup()
        build()
    }
}