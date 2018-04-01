package org.firezenk.comicworld.domain.models

data class CharacterModel(val id: String = "", val name: String = "",
                          val description: String? = "", val avatarUrl: String? = "")