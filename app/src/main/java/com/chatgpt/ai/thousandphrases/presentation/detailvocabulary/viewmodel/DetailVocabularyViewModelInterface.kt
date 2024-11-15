package com.chatgpt.ai.thousandphrases.presentation.detailvocabulary.viewmodel

import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.domain.ResultData
import kotlinx.coroutines.flow.StateFlow

interface DetailVocabularyViewModelInterface {
    fun getVerbs(): StateFlow<List<VocabularyUIModel>>
    fun getRootVocabulary(): StateFlow<VocabularyUIModel?>
    fun getNouns(): StateFlow<List<VocabularyUIModel>>
    fun getAdjectives(): StateFlow<List<VocabularyUIModel>>
    fun getSentences(): StateFlow<List<VocabularyUIModel>>
    fun setRootId(rootId: Int)
}

