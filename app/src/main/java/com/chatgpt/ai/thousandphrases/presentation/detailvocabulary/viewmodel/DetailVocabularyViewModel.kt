package com.chatgpt.ai.thousandphrases.presentation.detailvocabulary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chatgpt.ai.thousandphrases.mapper.RootVocabularyMapper.mapToUI
import com.chatgpt.ai.thousandphrases.mapper.VocabularyMapper.mapToUI
import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.data.VocabularyType
import com.domain.usecase.GetAdjByRootIdUseCase
import com.domain.usecase.GetNounByRootIdUseCase
import com.domain.usecase.GetRootVocabularyByIdUseCase
import com.domain.usecase.GetSentenceByRootIdUseCase
import com.domain.usecase.GetVerbByRootIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailVocabularyViewModel @Inject constructor(
    private val _getVerbByRootIdUseCase: GetVerbByRootIdUseCase,
    private val _getNounByRootIdUseCase: GetNounByRootIdUseCase,
    private val _getAdjByRootIdUseCase: GetAdjByRootIdUseCase,
    private val _getSentenceByRootIdUseCase: GetSentenceByRootIdUseCase,
    private val _getRootVocabularyByIdUseCase: GetRootVocabularyByIdUseCase

    ): ViewModel(),  DetailVocabularyViewModelInterface {
    private val _verbs = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _nouns = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _adjectives = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _sentences = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _rootVocabulary = MutableStateFlow<VocabularyUIModel?>(VocabularyUIModel(id = 0, vi = "", en = "", type = VocabularyType.NOUN))
    private var _rootId = 0

    override fun setRootId(rootId: Int) {
        _rootId = rootId
        viewModelScope.launch(Dispatchers.IO) {
            _getVerbByRootIdUseCase.execute(_rootId).collect {
                _verbs.value = it.map { it.mapToUI() }
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            _getNounByRootIdUseCase.execute(_rootId).collect {
                _nouns.value = it.map { it.mapToUI() }
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            _getAdjByRootIdUseCase.execute(_rootId).collect {
                _adjectives.value = it.map { it.mapToUI() }
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            _getSentenceByRootIdUseCase.execute(_rootId).collect {
                _sentences.value = it.map { it.mapToUI() }
            }
        }

        viewModelScope.launch(Dispatchers.IO) {
            _getRootVocabularyByIdUseCase.execute(_rootId).collect {
                _rootVocabulary.value = it?.mapToUI()
            }
        }
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

    override fun getRootVocabulary(): StateFlow<VocabularyUIModel?> {
        return _rootVocabulary
    }
}