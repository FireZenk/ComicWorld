package org.firezenk.comicworld.domain.usecases

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import org.firezenk.comicworld.domain.repositories.CharactersRepository
import javax.inject.Inject

class GetCharacter @Inject constructor(private val charactersRepository: CharactersRepository) {

    suspend fun execute(characterId: String) = async(CommonPool) {
        charactersRepository.character(characterId)
    }.await()
}