package com.domain.repository

import com.domain.ResultData
import com.domain.model.CategoryModel
import com.domain.model.SentenceModel
import kotlinx.coroutines.flow.Flow

interface SentenceRepository {
    fun getCategoriesSentence(): Flow<ResultData<List<CategoryModel>>>
    fun querySentence(query: String): Flow<ResultData<List<SentenceModel>>>
}