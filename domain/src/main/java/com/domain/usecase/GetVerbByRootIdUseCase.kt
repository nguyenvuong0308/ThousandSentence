package com.domain.usecase

import com.domain.repository.VocabularyRepository
import javax.inject.Inject

class GetVerbByRootIdUseCase @Inject constructor(private val _vocabularyRepository: VocabularyRepository) {
    suspend fun execute(rootId: Int) = _vocabularyRepository.getVerbs(rootId)
}