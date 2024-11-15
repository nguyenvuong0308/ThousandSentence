package com.domain.usecase

import com.domain.repository.VocabularyRepository
import javax.inject.Inject

class GetAdjByRootIdUseCase @Inject constructor(private val _vocabularyRepository: VocabularyRepository) {
    suspend fun execute(rootId: Int) = _vocabularyRepository.getAdjectives(rootId)
}