package org.firezenk.comicworld.domain.models

data class ComicModel(val id: String = "", val title: String = "",
                      val description: String?, val coverUrl: String? = "")