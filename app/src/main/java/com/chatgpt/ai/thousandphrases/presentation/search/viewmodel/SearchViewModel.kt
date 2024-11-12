package com.chatgpt.ai.thousandphrases.presentation.search.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.chatgpt.ai.thousandphrases.TextToSpeechExecute
import com.chatgpt.ai.thousandphrases.presentation.model.SentenceUIModel
import com.domain.usecase.QuerySentenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val _querySentenceUseCase: QuerySentenceUseCase,
    application: Application,
    private val _textToSpeechExecute: TextToSpeechExecute,
) : AndroidViewModel(application), SearchViewModelInterface {
    private val _searchResult: MutableStateFlow<List<SentenceUIModel>> = MutableStateFlow(
        arrayListOf(

        )
    )

    override val searchResult: StateFlow<List<SentenceUIModel>>
        get() = _searchResult

    init {
        query("")
    }

    override fun query(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _querySentenceUseCase.execute(query).collect {
                _searchResult.value = it.data?.map {
                    SentenceUIModel(
                        id = it.id,
                        vi = it.vi,
                        en = it.en
                    )
                } ?: arrayListOf()
            }
        }
    }

    override fun speak(text: String) {
        _textToSpeechExecute.speak(text, null)
    }
}