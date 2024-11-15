package com.domain.usecase

import com.domain.model.RootVocabularyItem
import com.domain.model.VocabularyItem
import com.domain.repository.VocabularyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRootVocabularyUseCase @Inject constructor(private val repository: VocabularyRepository) {
    suspend fun execute(): Flow<List<RootVocabularyItem>> {
        return repository.getRootVocabulary()
    }
}