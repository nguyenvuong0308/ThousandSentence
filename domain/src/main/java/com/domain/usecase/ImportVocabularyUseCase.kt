package com.domain.usecase

import com.domain.ResultData
import com.domain.VocabularyType
import com.domain.model.WrapVocabularyItem
import com.domain.model.importvocabulary.VocabularyFromImport
import com.domain.model.importvocabulary.mapToDomain
import com.google.gson.Gson
import javax.inject.Inject

class ImportVocabularyUseCase @Inject constructor() {
    suspend fun execute(json: String): ResultData<WrapVocabularyItem> {
        return try {
            val vocabularyFromImport = Gson().fromJson(json, VocabularyFromImport::class.java)
            ResultData.Success(  WrapVocabularyItem(
                adj = vocabularyFromImport.adj.map { it.mapToDomain(VocabularyType.ADJECTIVE) },
                noun = vocabularyFromImport.noun.map { it.mapToDomain(VocabularyType.NOUN) },
                verb = vocabularyFromImport.verb.map { it.mapToDomain(VocabularyType.VERB) },
                sentence = vocabularyFromImport.sentence.map { it.mapToDomain(VocabularyType.SENTENCE) }
            ))
        } catch (ex: Exception) {
            ResultData.Error(ex)
        }
    }
}