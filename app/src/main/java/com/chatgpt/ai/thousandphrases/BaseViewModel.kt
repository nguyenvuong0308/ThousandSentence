package com.chatgpt.ai.thousandphrases

import androidx.lifecycle.ViewModel

abstract class BaseViewModel(private val _textToSpeechExecute: TextToSpeechExecute): ViewModel(), ViewModelInterface {
    override fun speak(text: String) {
        _textToSpeechExecute.speak(text, null)
    }

    override fun onCleared() {
        _textToSpeechExecute.destroy()
    }
}