package com.chatgpt.ai.thousandphrases.presentation.addvocabulary.viewmodel

import com.chatgpt.ai.thousandphrases.presentation.model.RootVocabularyUIModel
import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.domain.ResultData
import kotlinx.coroutines.flow.StateFlow

interface AddVocabularyViewModelInterface {
    fun getSaveState(): StateFlow<ResultData<Boolean>>
    fun getVerbs(): StateFlow<List<VocabularyUIModel>>
    fun getRootVocabulary(): StateFlow<VocabularyUIModel>
    fun getNouns(): StateFlow<List<VocabularyUIModel>>
    fun getAdjectives(): StateFlow<List<VocabularyUIModel>>
    fun getSentences(): StateFlow<List<VocabularyUIModel>>

    fun addSentence(sentence: VocabularyUIModel)

    fun addVerb(verb: VocabularyUIModel)

    fun addNoun(noun: VocabularyUIModel)

    fun addAdjective(adjective: VocabularyUIModel)

    fun changeRootVocabulary(rootVocabulary: RootVocabularyUIModel)

    fun save()
}

