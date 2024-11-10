package com.chatgpt.ai.thousandphrases.presentation.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CategoryUIModel (
    var id: String,
    var name: String,
    var sentenceItems: List<SentenceUIModel>,
    var initSelected: Boolean
) {
    var isSelected by mutableStateOf(initSelected)
}