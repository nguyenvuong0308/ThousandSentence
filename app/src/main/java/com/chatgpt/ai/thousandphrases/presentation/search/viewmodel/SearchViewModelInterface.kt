package com.chatgpt.ai.thousandphrases.presentation.search.viewmodel

import com.chatgpt.ai.thousandphrases.presentation.model.SentenceUIModel
import kotlinx.coroutines.flow.StateFlow

interface SearchViewModelInterface {
    val searchResult: StateFlow<List<SentenceUIModel>>

    fun query(query: String)
    fun speak(text: String)
}