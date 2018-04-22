package org.firezenk.comicworld.ui.features.character

import org.firezenk.comicworld.domain.usecases.GetCharacter
import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

open class CharacterActions @Inject constructor(open val getCharacter: GetCharacter) : Action() {

    fun loadCharacter() = LoadCharacter(getCharacter)

    fun back(block: () -> Unit) = Back(getCharacter, block)

    class LoadCharacter(override val getCharacter: GetCharacter) : CharacterActions(getCharacter)
    data class Back(override val getCharacter: GetCharacter, val block: () -> Unit) : CharacterActions(getCharacter)
}