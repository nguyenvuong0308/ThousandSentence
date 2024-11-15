package com.chatgpt.ai.thousandphrases.presentation.model


class RootVocabularyUIModel (
    id: Int,
    vi: String,
    en: String,
    type: Int,
    var modifier: Long,
): VocabularyUIModel(id, vi, en, type)