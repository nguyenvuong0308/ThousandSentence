package com.chatgpt.ai.thousandphrases.presentation.vocabulary.vocabulary

import com.chatgpt.ai.thousandphrases.presentation.model.RootVocabularyUIModel
import kotlinx.coroutines.flow.StateFlow

interface VocabularyViewModelInterface {
    fun getVocabularies(): StateFlow<List<RootVocabularyUIModel>>
}