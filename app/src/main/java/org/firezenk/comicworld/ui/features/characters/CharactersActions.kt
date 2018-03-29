package org.firezenk.comicworld.ui.features.characters

import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

open class CharactersActions @Inject constructor() : Action() {

    class OpenCharacter : CharactersActions()
}