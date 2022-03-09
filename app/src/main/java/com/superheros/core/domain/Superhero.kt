package com.superheros.core.domain

import com.superheros.data.model.superheros.Thumbnail
import com.superheros.data.model.superheros.Urls
import java.io.Serializable

class Superhero (
    val id: Int?,
    val name: String?,
    val thumbnail: Thumbnail?,
    val urls: List<Urls>?
): Serializable