package com.superheros.core.data.sources

import com.superheros.core.data.Resource
import com.superheros.core.domain.Superhero


interface RemoteDataSource {
    suspend fun getSuperheros(): Resource<List<Superhero>>
}