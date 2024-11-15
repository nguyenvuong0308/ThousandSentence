package com.domain.usecase

import com.domain.model.VocabularyItem
import com.domain.repository.VocabularyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRootVocabularyByIdUseCase  @Inject constructor(private val _vocabularyRepository: VocabularyRepository) {
    suspend fun execute(rootId: Int) = _vocabularyRepository.getVocabularyByRootId(rootId)
}