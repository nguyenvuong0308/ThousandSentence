package com.data.repositoryimpl

import com.domain.VocabularyType
import com.data.database.MyDatabase
import com.data.mapper.RootVocabularyMapper.mapToData
import com.data.mapper.RootVocabularyMapper.mapToDomain
import com.data.mapper.VocabularyMapper.mapToData
import com.data.mapper.VocabularyMapper.mapToDomain
import com.domain.model.RootVocabularyItem
import com.domain.model.VocabularyItem
import com.domain.repository.VocabularyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VocabularyRepositoryImpl @Inject constructor(private val _myDatabase: MyDatabase) :
    VocabularyRepository {
    override suspend fun insert(
        rootVocabulary: RootVocabularyItem,
        verbs: List<VocabularyItem>,
        nouns: List<VocabularyItem>,
        adjectives: List<VocabularyItem>,
        sentences: List<VocabularyItem>,
    ) {
        val rootId = _myDatabase.rootVocabularyDao().insert(
            rootVocabulary.mapToData()
        ).toInt()

        _myDatabase.vocabularyDao().insertAll(verbs.map { it.mapToData(rootId) })
        _myDatabase.vocabularyDao().insertAll(nouns.map { it.mapToData(rootId) })
        _myDatabase.vocabularyDao().insertAll(adjectives.map { it.mapToData(rootId) })
        _myDatabase.vocabularyDao().insertAll(sentences.map { it.mapToData(rootId) })

    }

    override suspend fun getRootVocabulary(): Flow<List<RootVocabularyItem>> {
        return _myDatabase.rootVocabularyDao().getAllVocabulary()
            .map { it.map { it.mapToDomain() } }
    }

    override suspend fun getVerbs(rootId: Int): Flow<List<VocabularyItem>> {
        return _myDatabase.vocabularyDao().getVocabularyByRootId(rootId, VocabularyType.VERB).map {
            it.map { it.mapToDomain() }
        }
    }

    override suspend fun getNouns(rootId: Int): Flow<List<VocabularyItem>> {
        return _myDatabase.vocabularyDao().getVocabularyByRootId(rootId, VocabularyType.NOUN).map {
            it.map { it.mapToDomain() }
        }
    }

    override suspend fun getAdjectives(rootId: Int): Flow<List<VocabularyItem>> {
        return _myDatabase.vocabularyDao().getVocabularyByRootId(rootId, VocabularyType.ADJECTIVE).map {
            it.map { it.mapToDomain() }
        }
    }

    override suspend fun getSentences(rootId: Int): Flow<List<VocabularyItem>> {
        return _myDatabase.vocabularyDao().getVocabularyByRootId(rootId, VocabularyType.SENTENCE).map {
            it.map { it.mapToDomain() }
        }
    }

    override suspend fun getVocabularyByRootId(rootId: Int): Flow<RootVocabularyItem?> {
        return _myDatabase.rootVocabularyDao().getRootVocabularyById(rootId).map { it?.mapToDomain() }
    }
}