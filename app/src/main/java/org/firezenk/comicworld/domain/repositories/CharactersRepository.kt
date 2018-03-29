package org.firezenk.comicworld.domain.repositories

import com.karumi.marvelapiclient.CharacterApiClient
import com.karumi.marvelapiclient.model.MarvelImage
import org.firezenk.comicworld.domain.models.CharacterModel
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val api: CharacterApiClient) {

    fun characters(limit: Int = 20) = api.getAll(0, limit).response.characters
            .map { CharacterModel(it.id, it.name, it.description, it.thumbnail.getImageUrl(MarvelImage.Size.DETAIL)) }
}