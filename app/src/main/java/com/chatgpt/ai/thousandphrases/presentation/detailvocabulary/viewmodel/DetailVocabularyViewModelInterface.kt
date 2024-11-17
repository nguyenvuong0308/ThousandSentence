package com.chatgpt.ai.thousandphrases.presentation.detailvocabulary.viewmodel

import com.chatgpt.ai.thousandphrases.ViewModelInterface
import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.domain.ResultData
import kotlinx.coroutines.flow.StateFlow

interface DetailVocabularyViewModelInterface: ViewModelInterface {
    fun getVerbs(): StateFlow<List<VocabularyUIModel>>
    fun getRootVocabulary(): StateFlow<VocabularyUIModel?>
    fun getNouns(): StateFlow<List<VocabularyUIModel>>
    fun getAdjectives(): StateFlow<List<VocabularyUIModel>>
    fun getSentences(): StateFlow<List<VocabularyUIModel>>
    fun setRootId(rootId: Int)

    fun addSentence(sentence: VocabularyUIModel)

    fun addVerb(verb: VocabularyUIModel)

    fun addNoun(noun: VocabularyUIModel)

    fun addAdjective(adjective: VocabularyUIModel)

    fun save()
}

