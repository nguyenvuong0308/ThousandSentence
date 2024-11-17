package com.chatgpt.ai.thousandphrases.presentation.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chatgpt.ai.thousandphrases.MyApplication
import com.chatgpt.ai.thousandphrases.TextToSpeechExecute
import com.chatgpt.ai.thousandphrases.presentation.model.CategoryUIModel
import com.chatgpt.ai.thousandphrases.presentation.model.SentenceUIModel
import com.domain.ResultData
import com.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val _textToSpeechExecute: TextToSpeechExecute,
) : ViewModel(), MainViewModelInterface {

    private val _categories = MutableStateFlow<List<CategoryUIModel>>(arrayListOf())
    private val _sentenceItems = MutableStateFlow<List<SentenceUIModel>>(arrayListOf())

    override fun getSentenceItems(): StateFlow<List<SentenceUIModel>> = _sentenceItems
    override fun getCategories(): StateFlow<List<CategoryUIModel>> = _categories

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getCategoriesUseCase.execute().collect { result ->
                when (result) {
                    is ResultData.Success -> {
                        val categories = result.data!!.map {
                            CategoryUIModel(
                                id = it.id,
                                name = it.name,
                                initSelected = false,
                                sentenceItems = it.sentenceItems.map { sentenceItem ->
                                    SentenceUIModel(
                                        id = sentenceItem.id,
                                        vi = sentenceItem.vi,
                                        en = sentenceItem.en
                                    )
                                }
                            )
                        }
                        categories.getOrNull(0)?.isSelected = true
                        _categories.value = categories
                        _sentenceItems.value = _categories.value[0].sentenceItems
                    }

                    is ResultData.Error -> {
                        // Handle error case here
                    }

                    is ResultData.Loading -> {
                        // Handle loading case here
                    }

                    else -> {}
                }
            }
        }
    }

    override fun selectCategory(categoryUIModel: CategoryUIModel) {
        // Implementation for category selection
        _categories.value.forEach {
            it.isSelected = categoryUIModel.id == it.id
        }
        _categories.value = _categories.value.toList()
        _sentenceItems.value = categoryUIModel.sentenceItems
    }

    override fun speak(text: String) {
        _textToSpeechExecute.speak(text, null)
    }

    override fun onCleared() {
        super.onCleared()
        _textToSpeechExecute.destroy()
    }

}
