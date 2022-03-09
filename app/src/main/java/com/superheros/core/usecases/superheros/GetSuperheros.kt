package com.superheros.core.usecases.superheros

import com.superheros.core.data.Resource
import com.superheros.core.data.repository.superheros.SuperherosRepository
import com.superheros.core.domain.Superhero
import com.superheros.core.usecases.BaseUseCase
import javax.inject.Inject

class GetSuperheros @Inject constructor(private val superherosRepository: SuperherosRepository) :
    BaseUseCase<List<Superhero>, Unit>() {

    override suspend fun buildUseCaseSingle(params: Unit): Resource<List<Superhero>> {
        return superherosRepository.getSuperheros()
    }

}