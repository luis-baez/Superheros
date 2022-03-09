package com.superheros.core.data.repository.superheros

import com.superheros.BuildConfig
import com.superheros.core.data.Resource
import com.superheros.core.data.sources.RemoteDataSource
import com.superheros.core.domain.Superhero
import com.superheros.ui.utils.toMD5

class SuperherosRepositoryImpl (
    val remoteDataSource: RemoteDataSource
) : SuperherosRepository {

    override suspend fun getSuperheros(): Resource<List<Superhero>> {
        return remoteDataSource.getSuperheros()
    }

}