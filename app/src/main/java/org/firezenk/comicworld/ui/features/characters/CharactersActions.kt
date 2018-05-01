package org.firezenk.comicworld.ui.features.characters

import org.firezenk.comicworld.domain.usecases.GetCharacters
import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

open class CharactersActions @Inject constructor(open val getCharacters: GetCharacters) : Action() {

    fun loadCharacters() = LoadCharacters(getCharacters)

    fun openCharacter(id: String) = OpenCharacter(getCharacters, id)

    fun back(block: () -> Unit) = Back(getCharacters, block)

    class LoadCharacters(override val getCharacters: GetCharacters) : CharactersActions(getCharacters)

    class OpenCharacter(override val getCharacters: GetCharacters, val id: String) : CharactersActions(getCharacters)

    class Back(override val getCharacters: GetCharacters, val block: () -> Unit) : CharactersActions(getCharacters)
}