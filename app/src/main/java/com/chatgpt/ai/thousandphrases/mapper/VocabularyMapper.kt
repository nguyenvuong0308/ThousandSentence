package com.chatgpt.ai.thousandphrases.mapper

import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.domain.model.VocabularyItem

object VocabularyMapper {
    fun VocabularyUIModel.mapToDomain() = VocabularyItem(
        id = id,
        vi = vi,
        en = en,
        type = type
    )

    fun VocabularyItem.mapToUI() = VocabularyUIModel(
        id = id,
        vi = vi,
        en = en,
        type = type
    )
}