package com.chatgpt.ai.thousandphrases.presentation.detailvocabulary.viewmodel

import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.data.VocabularyType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailVocabularyViewModelMock: DetailVocabularyViewModelInterface {
    private val _verbs = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _nouns = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _adjectives = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _sentences = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _rootVocabulary = MutableStateFlow<VocabularyUIModel?>(VocabularyUIModel(id = 0, vi = "", en = "", type = VocabularyType.NOUN))

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

    override fun getRootVocabulary(): StateFlow<VocabularyUIModel?> {
        return _rootVocabulary
    }

    override fun setRootId(rootId: Int) {

    }
}