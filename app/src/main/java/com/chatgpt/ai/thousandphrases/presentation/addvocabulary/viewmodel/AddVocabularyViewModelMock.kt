package com.chatgpt.ai.thousandphrases.presentation.addvocabulary.viewmodel

import com.chatgpt.ai.thousandphrases.presentation.model.RootVocabularyUIModel
import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.domain.VocabularyType
import com.domain.ResultData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddVocabularyViewModelMock : AddVocabularyViewModelInterface {
    private val _verbs = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _nouns = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _adjectives = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _sentences = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _saveState = MutableStateFlow<ResultData<Boolean>>(ResultData.StandBy())
    private val _importState = MutableStateFlow<ResultData<Boolean>>(ResultData.StandBy())
    private val _rootVocabulary = MutableStateFlow(VocabularyUIModel(id = 0, vi = "", en = "", type = VocabularyType.NOUN))

    override fun getSaveState(): StateFlow<ResultData<Boolean>> {
        return _saveState
    }

    override fun getRootVocabulary(): StateFlow<VocabularyUIModel> {
        return _rootVocabulary
    }

    override fun changeRootVocabulary(rootVocabulary: RootVocabularyUIModel) {
        _rootVocabulary.value = rootVocabulary
    }

    override fun addVerb(verb: VocabularyUIModel) {
        _verbs.value += verb
    }

    override fun addNoun(noun: VocabularyUIModel) {
        _nouns.value += noun
    }

    override fun addAdjective(adjective: VocabularyUIModel) {
        _adjectives.value += adjective
    }

    override fun save() {
        _saveState.value = ResultData.Success(true)
    }

    override fun getVerbs(): StateFlow<List<VocabularyUIModel>> {
        return _verbs
    }

    override fun getNouns(): StateFlow<List<VocabularyUIModel>> {
        return _nouns
    }

    override fun getAdjectives(): StateFlow<List<VocabularyUIModel>> {
        return _adjectives
    }

    override fun getSentences(): StateFlow<List<VocabularyUIModel>> {
        return _sentences
    }

    override fun addSentence(sentence: VocabularyUIModel) {
        _sentences.value += sentence
    }

    override fun getImportState(): StateFlow<ResultData<Boolean>> {
        return _importState
    }

    override fun importVocabulary(json: String) {
    }
}