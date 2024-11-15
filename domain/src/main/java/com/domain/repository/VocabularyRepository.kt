package com.domain.repository

import com.domain.model.RootVocabularyItem
import com.domain.model.VocabularyItem
import kotlinx.coroutines.flow.Flow

interface VocabularyRepository {
    suspend fun insert(
        rootVocabulary: RootVocabularyItem,
        verbs: List<VocabularyItem>,
        nouns: List<VocabularyItem>,
        adjectives: List<VocabularyItem>,
        sentences: List<VocabularyItem>,
    )

    suspend fun getRootVocabulary(): Flow<List<RootVocabularyItem>>

    suspend fun getVerbs(rootId: Int): Flow<List<VocabularyItem>>

    suspend fun getNouns(rootId: Int): Flow<List<VocabularyItem>>

    suspend fun getAdjectives(rootId: Int): Flow<List<VocabularyItem>>

    suspend fun getSentences(rootId: Int): Flow<List<VocabularyItem>>

    suspend fun getVocabularyByRootId(rootId: Int): Flow<RootVocabularyItem?>
}