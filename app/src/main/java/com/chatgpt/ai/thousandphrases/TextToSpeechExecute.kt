package com.chatgpt.ai.thousandphrases

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

class TextToSpeechExecute @Inject constructor(@ApplicationContext context: Context) {
    private var _textToSpeech: TextToSpeech? = null
    private var _playId: Long? = null
    var onSpeakFinished: ((playId: Long?) -> Unit)? = null
    var onSpeakError: ((playId: Long?) -> Unit)? = null
    var onSpeakStart: ((playId: Long?) -> Unit)? = null

    init {
        _textToSpeech = TextToSpeech(context, {
            val language = context.resources.configuration.locale
            val result = _textToSpeech?.setLanguage(language)
            if (result != TextToSpeech.LANG_AVAILABLE) {
                _textToSpeech?.language = Locale.US
            }
            _textToSpeech?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                override fun onStart(utteranceId: String?) {
                    CoroutineScope(Dispatchers.Main).launch {
                        onSpeakStart?.invoke(_playId)
                    }
                }

                override fun onDone(utteranceId: String?) {
                    CoroutineScope(Dispatchers.Main).launch {
                        onSpeakFinished?.invoke(_playId)
                    }
                }

                override fun onError(utteranceId: String?) {
                    CoroutineScope(Dispatchers.Main).launch {
                        onSpeakError?.invoke(_playId)
                    }
                }

                override fun onStop(utteranceId: String?, interrupted: Boolean) {
                    CoroutineScope(Dispatchers.Main).launch {
                        onSpeakFinished?.invoke(_playId)
                    }
                }

            })
        }, "com.google.android.tts")

    }

    fun speak(text: String, playId: Long?) {
        if(isSpeaking()) {
            stop()
        }
        _playId = playId
        _textToSpeech?.speak(text, TextToSpeech.QUEUE_ADD, null, "")
    }

    fun destroy() {
        _textToSpeech?.stop()
        _textToSpeech?.shutdown()
    }

    fun isSpeaking(): Boolean {
        return _textToSpeech?.isSpeaking ?: false
    }

    fun stop() {
        _textToSpeech?.stop()
    }
}
