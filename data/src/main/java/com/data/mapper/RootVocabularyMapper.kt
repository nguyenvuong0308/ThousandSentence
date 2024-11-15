package com.data.mapper

import com.data.database.vocabulary.RootVocabularyItemDB
import com.domain.model.RootVocabularyItem
import com.domain.model.VocabularyItem

object RootVocabularyMapper {
    fun RootVocabularyItem.mapToData() = RootVocabularyItemDB(
        id = id,
        vi = vi,
        en = en,
        type = type,
        modifier = modifier
    )

    fun RootVocabularyItemDB.mapToDomain() = RootVocabularyItem(
        id = id,
        vi = vi,
        en = en,
        type = type,
        modifier = modifier
    )

}