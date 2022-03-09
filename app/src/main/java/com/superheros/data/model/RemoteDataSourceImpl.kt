package com.superheros.data.model


import com.superheros.BuildConfig
import com.superheros.core.data.Resource
import com.superheros.core.data.sources.RemoteDataSource
import com.superheros.core.domain.Superhero
import com.superheros.data.api.SuperherosService
import com.superheros.ui.utils.toDomain
import com.superheros.ui.utils.toMD5

class RemoteDataSourceImpl(val service: SuperherosService) : RemoteDataSource {

    private val ts = System.currentTimeMillis().toString()
    private val hash = (ts + BuildConfig.PRIVATE_KEY + BuildConfig.API_KEY).toMD5()

    override suspend fun getSuperheros(): Resource<List<Superhero>> {
        return try {
            val response = service.getSuperheros(ts, BuildConfig.API_KEY, hash)
            if (response.isSuccessful) {
                Resource.Success(response.body()?.dataSuperheros?.superheros?.map {
                    it.toDomain()
                }!!)
            } else {
                Resource.ErrorBody(response.errorBody().toString())
            }
        } catch (e: Exception) {
            Resource.ErrorException(e)
        }
    }

}