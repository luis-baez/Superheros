package com.superheros.ui.utils

import com.superheros.core.domain.Superhero
import com.superheros.data.model.superheros.SuperHerosResult

fun SuperHerosResult.Superhero.toDomain() =
    Superhero(
        this.id?:0,
        this.name?:"",
        this.thumbnail,
        this.urls?: emptyList()
    )