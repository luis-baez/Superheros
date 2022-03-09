package com.superheros.core.data.repository.superheros

import com.superheros.core.data.Resource
import com.superheros.core.domain.Superhero

interface SuperherosRepository {
    suspend fun getSuperheros() : Resource<List<Superhero>>
}