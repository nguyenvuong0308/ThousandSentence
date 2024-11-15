package com.chatgpt.ai.thousandphrases.presentation.vocabulary.vocabulary

import com.chatgpt.ai.thousandphrases.presentation.model.RootVocabularyUIModel
import com.data.VocabularyType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class VocabularyViewModelMock : VocabularyViewModelInterface {

    private val _vocabularies = MutableStateFlow<List<RootVocabularyUIModel>>(
        arrayListOf(
            RootVocabularyUIModel(
                id = 0,
                vi = "Vi",
                en = "En",
                type = VocabularyType.VERB,
                modifier = System.currentTimeMillis()
            ),
            RootVocabularyUIModel(
                id = 0,
                vi = "Vi",
                en = "En",
                type = VocabularyType.VERB,
                modifier = System.currentTimeMillis()
            )
        )
    )

    override fun getVocabularies(): StateFlow<List<RootVocabularyUIModel>> {
        return _vocabularies
    }

}