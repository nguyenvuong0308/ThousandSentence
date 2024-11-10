package com.domain

sealed class ResultData<T>(var data: T?) {
    class Success<T>(data: T?) : ResultData<T>(data)
    class Error<T>(var error: Exception) : ResultData<T>(null)
    class Loading<T> : ResultData<T>(null)
}