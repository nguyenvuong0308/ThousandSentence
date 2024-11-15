package com.chatgpt.ai.thousandphrases.mapper

import com.chatgpt.ai.thousandphrases.Utils
import com.chatgpt.ai.thousandphrases.presentation.model.RootVocabularyUIModel
import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.domain.model.RootVocabularyItem
import com.domain.model.VocabularyItem

object RootVocabularyMapper {
    fun RootVocabularyUIModel.mapToDomain() = RootVocabularyItem(
        id = id,
        vi = vi,
        en = en,
        type = type,
        modifier = modifier
    )

    fun RootVocabularyItem.mapToUI() = RootVocabularyUIModel(
        id = id,
        vi = vi,
        en = en,
        type = type,
        modifier = modifier
    )
}