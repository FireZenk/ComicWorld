package org.firezenk.comicworld.ui.extensions

import android.support.annotation.StringRes
import android.view.View
import android.widget.Toast

fun View.toast(@StringRes message: Int) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}