package com.domain.usecase

import com.domain.ResultData
import com.domain.model.CategoryModel
import com.domain.repository.SentenceRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetCategoriesUseCase @Inject constructor(private val _repository: SentenceRepository) {
    fun execute(): Flow<ResultData<List<CategoryModel>>> {
        return _repository.getCategoriesSentence()
    }
}