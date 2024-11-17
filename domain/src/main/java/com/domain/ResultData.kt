package com.domain

import kotlin.jvm.Throws

sealed class ResultData<T>(var data: T?, var error: Throwable?=null) {
    class Success<T>(data: T?) : ResultData<T>(data)
    class Error<T>(error: Throwable? = null) : ResultData<T>(null)
    class Loading<T> : ResultData<T>(null)
    class StandBy<T> : ResultData<T>(null)
}