package com.example.weathers.domain.usecase

import io.ktor.client.statement.HttpResponse

abstract class ResultState<out T> {

    object Loading : ResultState<Nothing>()

    data class Success<T>(val response: T) : ResultState<T>()

    data class Error(val error: Throwable) : ResultState<Nothing>()

}