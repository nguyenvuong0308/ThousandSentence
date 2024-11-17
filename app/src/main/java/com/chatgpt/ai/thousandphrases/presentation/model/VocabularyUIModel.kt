package com.chatgpt.ai.thousandphrases.presentation.model

open class VocabularyUIModel (
    var id: Int,
    var vi: String,
    var en: String,
    var type: Int
) {
    fun isNotEmpty(): Boolean {
        return vi.isNotEmpty() && en.isNotEmpty()
    }
}