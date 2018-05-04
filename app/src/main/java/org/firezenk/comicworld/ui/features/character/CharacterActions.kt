package org.firezenk.comicworld.ui.features.character

import org.firezenk.comicworld.domain.usecases.GetCharacter
import org.firezenk.comicworld.ui.features.commons.Action
import javax.inject.Inject

class CharacterActions @Inject constructor(private val getCharacter: GetCharacter) : Action() {

    fun loadCharacter() = LoadCharacter(getCharacter)

    fun back(block: () -> Unit) = Back(block)

    sealed class CharacterAction : Action() {

        class LoadCharacter(val getCharacter: GetCharacter) : CharacterAction()
        data class Back(val block: () -> Unit) : CharacterAction()
    }
}

typealias Actions = CharacterActions.CharacterAction
typealias LoadCharacter = CharacterActions.CharacterAction.LoadCharacter
typealias Back = CharacterActions.CharacterAction.Back