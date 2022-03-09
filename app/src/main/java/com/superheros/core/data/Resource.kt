package com.superheros.core.data

sealed class Resource<out T : Any> {

    data class Success<out T : Any>(val value: T) : Resource<T>()

    data class ErrorBody(val errorBody: String) : Resource<Nothing>()

    data class ErrorException(val exception: Exception) : Resource<Nothing>()

}