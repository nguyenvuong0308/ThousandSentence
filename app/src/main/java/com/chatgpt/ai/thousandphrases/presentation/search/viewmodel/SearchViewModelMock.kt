package com.chatgpt.ai.thousandphrases.presentation.search.viewmodel

import com.chatgpt.ai.thousandphrases.presentation.model.SentenceUIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModelMock : SearchViewModelInterface {
    private val sentences = arrayListOf(
        SentenceUIModel(id = "XinChao", vi = "Xin chào", en = "Hello"),
        SentenceUIModel(id = "XinChao1", vi = "Xin chào1", en = "Hello1"),
        SentenceUIModel(id = "XinChao2", vi = "Xin chào2", en = "Hello2"),
        SentenceUIModel(id = "XinChao3", vi = "Xin chào3", en = "Hello3"),
        SentenceUIModel(id = "XinChao4", vi = "Xin chào4", en = "Hello4"),
        SentenceUIModel(id = "XinChao5", vi = "Xin chào5", en = "Hello5"),
    )

    private val _searchResult: MutableStateFlow<List<SentenceUIModel>> = MutableStateFlow(
        arrayListOf(

        )
    )
    override val searchResult: StateFlow<List<SentenceUIModel>>
        get() = _searchResult

    init {
        _searchResult.value = sentences
    }
    override fun query(query: String) {
        _searchResult.value = sentences.filter { it.vi.contains(query) || it.en.contains(query) }
    }

    override fun speak(text: String) {

    }
}