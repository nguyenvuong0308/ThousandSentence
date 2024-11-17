package com.chatgpt.ai.thousandphrases.presentation.vocabulary.vocabulary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chatgpt.ai.thousandphrases.BaseViewModel
import com.chatgpt.ai.thousandphrases.TextToSpeechExecute
import com.chatgpt.ai.thousandphrases.mapper.RootVocabularyMapper.mapToUI
import com.chatgpt.ai.thousandphrases.presentation.model.RootVocabularyUIModel
import com.domain.usecase.GetRootVocabularyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VocabularyViewModel @Inject constructor(
    private val _getRootVocabularyUseCase: GetRootVocabularyUseCase,
    _textToSpeechExecute: TextToSpeechExecute,
) : BaseViewModel(_textToSpeechExecute),
    VocabularyViewModelInterface {

    private val _vocabularies = MutableStateFlow<List<RootVocabularyUIModel>>(arrayListOf())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _getRootVocabularyUseCase.execute().collect {
                _vocabularies.value = it.map { it.mapToUI() }
            }
        }
    }

    override fun getVocabularies(): StateFlow<List<RootVocabularyUIModel>> {
        return _vocabularies
    }
}