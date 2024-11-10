package com.chatgpt.ai.thousandphrases.presentation.main.viewmodel

import com.chatgpt.ai.thousandphrases.presentation.model.CategoryUIModel
import com.chatgpt.ai.thousandphrases.presentation.model.SentenceUIModel
import kotlinx.coroutines.flow.StateFlow

interface MainViewModelInterface {
    fun getCategories(): StateFlow<List<CategoryUIModel>>
    fun getSentenceItems(): StateFlow<List<SentenceUIModel>>
    fun selectCategory(categoryUIModel: CategoryUIModel)
}