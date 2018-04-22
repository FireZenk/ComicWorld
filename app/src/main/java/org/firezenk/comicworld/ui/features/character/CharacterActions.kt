package org.firezenk.comicworld.ui.features.character

import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

open class CharacterActions @Inject constructor() : Action() {

    fun back() = Back()

    class Back : CharacterActions()
}