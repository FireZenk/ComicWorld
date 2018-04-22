package org.firezenk.comicworld.domain.repositories

import com.karumi.marvelapiclient.CharacterApiClient
import com.karumi.marvelapiclient.model.CharacterDto
import com.karumi.marvelapiclient.model.MarvelImage
import org.firezenk.comicworld.domain.models.CharacterModel
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val api: CharacterApiClient) {

    fun characters(offset: Int = 100, limit: Int = 40) = api.getAll(offset, limit).response.characters
            .map { mapCharacter(it) }

    fun character(characterId: String) = api.getCharacter(characterId).response
            .let { mapCharacter(it) }

    private fun mapCharacter(it: CharacterDto)
            = CharacterModel(it.id, it.name, it.description, it.thumbnail.getImageUrl(MarvelImage.Size.DETAIL))
}