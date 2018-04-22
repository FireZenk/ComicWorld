package org.firezenk.comicworld.ui.features.character

import org.firezenk.comicworld.domain.models.CharacterModel
import org.firezenk.comicworld.ui.features.commons.State
import javax.inject.Inject

open class CharacterStates @Inject constructor() : State() {

    fun success(model: CharacterModel) = Loaded(model.name)

    data class Loaded(val name: String): CharacterStates()
}