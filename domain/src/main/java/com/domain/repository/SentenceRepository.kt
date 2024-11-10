package com.domain.repository

import com.domain.ResultData
import com.domain.model.CategoryModel
import kotlinx.coroutines.flow.Flow

interface SentenceRepository {
    fun getCategoriesSentence(): Flow<ResultData<List<CategoryModel>>>
}