package com.chatgpt.ai.thousandphrases.presentation.addvocabulary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chatgpt.ai.thousandphrases.mapper.RootVocabularyMapper.mapToDomain
import com.chatgpt.ai.thousandphrases.mapper.VocabularyMapper.mapToDomain
import com.chatgpt.ai.thousandphrases.mapper.VocabularyMapper.mapToUI
import com.chatgpt.ai.thousandphrases.presentation.model.RootVocabularyUIModel
import com.chatgpt.ai.thousandphrases.presentation.model.VocabularyUIModel
import com.domain.VocabularyType
import com.domain.ResultData
import com.domain.usecase.AddNewVocabularyUseCase
import com.domain.usecase.ImportVocabularyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddVocabularyViewModel @Inject constructor(private val _addNewVocabularyUseCase: AddNewVocabularyUseCase, private val _importVocabularyUseCase: ImportVocabularyUseCase): ViewModel(),
    AddVocabularyViewModelInterface {
    private val _saveState = MutableStateFlow<ResultData<Boolean>>(ResultData.StandBy())
    private val _importState = MutableStateFlow<ResultData<Boolean>>(ResultData.StandBy())
    private val _verbs = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _nouns = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _adjectives = MutableStateFlow<List<VocabularyUIModel>>(emptyList())
    private val _sentences = MutableStateFlow<List<VocabularyUIModel>>(emptyList())

    private val _rootVocabulary = MutableStateFlow(RootVocabularyUIModel(id = 0, vi = "", en = "", type = VocabularyType.NOUN, modifier = System.currentTimeMillis()))

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
        viewModelScope.launch(Dispatchers.IO) {
            _addNewVocabularyUseCase.execute(
                rootVocabulary = _rootVocabulary.value.mapToDomain(),
                verbs = _verbs.value.map { it.mapToDomain() },
                nouns = _nouns.value.map { it.mapToDomain() },
                adjectives = _adjectives.value.map { it.mapToDomain() },
                sentences = _sentences.value.map { it.mapToDomain() }
            )
            _saveState.emit(ResultData.Success(true))
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

    override fun addSentence(sentence: VocabularyUIModel) {
        _sentences.value += sentence
    }

    override fun getImportState(): StateFlow<ResultData<Boolean>> {
        return _importState
    }

    override fun importVocabulary(json: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val resultData = _importVocabularyUseCase.execute(json)
            when(resultData) {
                is ResultData.Success -> {
                    resultData.data?.noun?.forEach {
                        _nouns.value += it.mapToUI()
                    }

                    resultData.data?.verb?.forEach {
                        _verbs.value += it.mapToUI()
                    }

                    resultData.data?.adj?.forEach {
                        _adjectives.value += it.mapToUI()
                    }

                    resultData.data?.sentence?.forEach {
                        _sentences.value += it.mapToUI()
                    }

                    _importState.emit(ResultData.Success(true))
                }

                is ResultData.Error -> {
                    _importState.emit(ResultData.Error(resultData.error))
                }

                else -> {

                }
            }

        }
    }
}