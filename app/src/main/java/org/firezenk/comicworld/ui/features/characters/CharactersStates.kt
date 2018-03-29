package org.firezenk.comicworld.ui.features.characters

import org.firezenk.comicworld.domain.models.CharacterModel
import org.firezenk.comicworld.ui.features.commons.State
import javax.inject.Inject

open class CharactersStates @Inject constructor() : State() {

    fun success(list: List<CharacterModel>) = Success(list)

    data class Success(val list: List<CharacterModel>) : CharactersStates()
}