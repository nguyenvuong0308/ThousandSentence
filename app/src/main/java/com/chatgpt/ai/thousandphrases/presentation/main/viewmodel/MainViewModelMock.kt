package com.chatgpt.ai.thousandphrases.presentation.main.viewmodel

import com.chatgpt.ai.thousandphrases.presentation.model.CategoryUIModel
import com.chatgpt.ai.thousandphrases.presentation.model.SentenceUIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModelMock : MainViewModelInterface {


    private val _categories = MutableStateFlow(
        listOf(
            CategoryUIModel(
                id = "name1",
                name = "name1",
                initSelected = true,
                sentenceItems = arrayListOf(
                    SentenceUIModel("vi1", "v1", "en1"),
                    SentenceUIModel("vi1", "v1", "en1"),
                    SentenceUIModel("vi1", "v1", "en1"),
                    SentenceUIModel("vi1", "v1", "en1"),
                    SentenceUIModel("vi1", "v1", "en1")
                )
            ),
            CategoryUIModel(
                id = "name2",
                name = "name2",
                initSelected = false,
                sentenceItems = arrayListOf(
                    SentenceUIModel("vi2", "vi2", "en2"),
                    SentenceUIModel("vi2", "vi2", "en2"),
                    SentenceUIModel("vi2", "vi2", "en2"),
                    SentenceUIModel("vi2", "vi2", "en2"),
                    SentenceUIModel("vi2", "vi2", "en2"),
                )
            ),
            CategoryUIModel(
                id = "name3",
                name = "name3",
                initSelected = false,
                sentenceItems = arrayListOf(
                    SentenceUIModel("vi3", "vi3", "en3"),
                    SentenceUIModel("vi3", "vi3", "en3"),
                    SentenceUIModel("vi3", "vi3", "en3"),
                    SentenceUIModel("vi3", "vi3", "en3"),
                    SentenceUIModel("vi3", "vi3", "en3"),
                )
            )
        )
    )

    private val _sentenceItems = MutableStateFlow(
        listOf(
            SentenceUIModel("vi1", "v1", "en1"),
            SentenceUIModel("vi1", "v1", "en1"),
            SentenceUIModel("vi1", "v1", "en1"),
            SentenceUIModel("vi1", "v1", "en1"),
            SentenceUIModel("vi1", "v1", "en1")
        )
    )

    override fun getSentenceItems(): StateFlow<List<SentenceUIModel>> = _sentenceItems

    override fun getCategories(): StateFlow<List<CategoryUIModel>> = _categories

    override fun selectCategory(categoryUIModel: CategoryUIModel) {
        // Update the isSelected state for each item
        _categories.value.forEach { it.isSelected = it.id == categoryUIModel.id }

        // Re-assign the list to trigger StateFlow emission
        _categories.value = _categories.value.toList()
        _sentenceItems.value = categoryUIModel.sentenceItems
    }

    override fun speak(text: String) {

    }
}