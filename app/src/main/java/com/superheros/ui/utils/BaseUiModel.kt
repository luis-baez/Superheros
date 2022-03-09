package com.superheros.ui.utils

sealed class BaseUiModel<out T> {
    class Success<T>(val data: T) : BaseUiModel<T>()
    class Error(val error: String) : BaseUiModel<Nothing>()
    class ErrorEx(val ex: Exception) : BaseUiModel<Nothing>()
}