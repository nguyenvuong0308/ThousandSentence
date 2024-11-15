package com.domain.usecase

import com.domain.model.RootVocabularyItem
import com.domain.model.VocabularyItem
import com.domain.repository.VocabularyRepository
import javax.inject.Inject

class AddNewVocabularyUseCase @Inject constructor(private val repository: VocabularyRepository) {
    suspend fun execute(
        rootVocabulary: RootVocabularyItem,
        verbs: List<VocabularyItem>,
        nouns: List<VocabularyItem>,
        adjectives: List<VocabularyItem>,
        sentences: List<VocabularyItem>,
    ) {
        repository.insert(rootVocabulary, verbs, nouns, adjectives, sentences)
    }
}