package com.chatgpt.ai.thousandphrases.presentation.vocabulary.vocabulary

import com.chatgpt.ai.thousandphrases.ViewModelInterface
import com.chatgpt.ai.thousandphrases.presentation.model.RootVocabularyUIModel
import kotlinx.coroutines.flow.StateFlow

interface VocabularyViewModelInterface: ViewModelInterface {
    fun getVocabularies(): StateFlow<List<RootVocabularyUIModel>>
}