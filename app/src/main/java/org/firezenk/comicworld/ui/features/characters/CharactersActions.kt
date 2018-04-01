package org.firezenk.comicworld.ui.features.characters

import org.firezenk.comicworld.domain.usecases.GetCharacters
import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

open class CharactersActions @Inject constructor(open val getCharacters: GetCharacters) : Action() {

    fun loadCharacters() = LoadCharacters(getCharacters)

    class LoadCharacters(override val getCharacters: GetCharacters) : CharactersActions(getCharacters)
}