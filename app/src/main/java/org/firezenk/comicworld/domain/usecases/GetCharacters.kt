package org.firezenk.comicworld.domain.usecases

import org.firezenk.comicworld.domain.repositories.CharactersRepository
import javax.inject.Inject

class GetCharacters @Inject constructor(private val charactersRepository: CharactersRepository) {

    fun execute() = charactersRepository.characters()
}