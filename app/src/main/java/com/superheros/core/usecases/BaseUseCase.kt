package com.superheros.core.usecases

import com.superheros.core.data.Resource

abstract class BaseUseCase<T, in P> {

    internal abstract suspend fun buildUseCaseSingle(params: P): Resource<Any>

}