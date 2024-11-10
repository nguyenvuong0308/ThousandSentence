package com.chatgpt.ai.thousandphrases.presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chatgpt.ai.thousandphrases.presentation.model.CategoryUIModel
import com.chatgpt.ai.thousandphrases.presentation.model.SentenceUIModel
import com.domain.ResultData
import com.domain.repository.SentenceRepository
import com.domain.usecase.GetCategoriesUseCase
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
class MainViewModel5 @Inject constructor(
    var repository: SentenceRepository
) : ViewModel(), MainViewModelInterface {

    private val _categories = MutableStateFlow<List<CategoryUIModel>>(arrayListOf())
    private val _sentenceItems = MutableStateFlow<List<SentenceUIModel>>(arrayListOf())

    override fun getSentenceItems(): StateFlow<List<SentenceUIModel>> = _sentenceItems
    override fun getCategories(): StateFlow<List<CategoryUIModel>> = _categories

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCategoriesSentence().collect { result ->
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
                        categories.getOrNull(0)?.initSelected = true
                        _categories.value = categories
                        _sentenceItems.value = _categories.value[0].sentenceItems
                    }

                    is ResultData.Error -> {
                        // Handle error case here
                    }

                    is ResultData.Loading -> {
                        // Handle loading case here
                    }
                }
            }
        }
    }

    override fun selectCategory(categoryUIModel: CategoryUIModel) {
        // Implementation for category selection
    }
}
