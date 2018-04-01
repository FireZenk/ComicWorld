package org.firezenk.comicworld.domain.repositories

import com.karumi.marvelapiclient.ComicApiClient
import com.karumi.marvelapiclient.model.MarvelImage
import org.firezenk.comicworld.domain.models.ComicModel
import javax.inject.Inject

class ComicsRepository @Inject constructor(private val api: ComicApiClient) {

    fun comics(limit: Int = 20) = api.getAll(0, limit).response.comics
            .map { ComicModel(it.id, it.title, it.description, it.thumbnail.getImageUrl(MarvelImage.Size.DETAIL)) }
}