package org.firezenk.comicworld.ui.features.character

import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import org.firezenk.comicworld.ui.features.commons.Presenter
import org.firezenk.kartographer.library.Kartographer
import javax.inject.Inject

class CharacterPresenter @Inject constructor(router: Kartographer, private val states: CharacterStates)
    : Presenter<CharacterActions, CharacterStates, CharacterView>(router) {

    private lateinit var id: String

    override fun init(view: CharacterView) {
        id = router.payload<String>("id")!!
        super.init(view)
    }

    override fun reduce(action: CharacterActions) {
        when (action) {
            is CharacterActions.LoadCharacter -> launch(UI) {
                val model = action.getCharacter.execute(id).toEither()
                model.fold({
                    render(states.error())
                }, {
                    render(states.success(it))
                })
            }
            is CharacterActions.Back -> router.backOnPath { action.block }
        }
    }
}