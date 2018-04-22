package org.firezenk.comicworld.ui.features.character

import org.firezenk.comicworld.ui.features.commons.Presenter
import org.firezenk.kartographer.library.Kartographer
import javax.inject.Inject

class CharacterPresenter @Inject constructor(router: Kartographer, private val states: CharacterStates)
    : Presenter<CharacterActions, CharacterStates, CharacterView>(router) {

    override fun reduce(action: CharacterActions) {
        when (action) {
            is CharacterActions.Back -> router.backOnPath { action.block }
        }
    }
}