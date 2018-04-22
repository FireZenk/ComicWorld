package org.firezenk.comicworld.domain.usecases

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import org.firezenk.comicworld.domain.repositories.ComicsRepository
import javax.inject.Inject

class GetComics @Inject constructor(private val comicsRepository: ComicsRepository) {

    suspend fun execute() = async(CommonPool) {
        comicsRepository.comics()
    }.await()
}