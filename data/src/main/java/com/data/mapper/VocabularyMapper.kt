package com.data.mapper

import com.data.database.vocabulary.VocabularyItemDB
import com.domain.model.VocabularyItem

object VocabularyMapper {
    fun VocabularyItem.mapToData(rootId: Int) = VocabularyItemDB(
        id = id,
        vi = vi,
        en = en,
        type = type,
        rootId = rootId
    )

    fun VocabularyItemDB.mapToDomain() = VocabularyItem(
        id = id,
        vi = vi,
        en = en,
        type = type
    )
}