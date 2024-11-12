package com.domain.usecase

import com.domain.repository.SentenceRepository
import javax.inject.Inject

class QuerySentenceUseCase @Inject constructor(private val _sentenceRepository: SentenceRepository) {
    fun execute(query: String) = _sentenceRepository.querySentence(query)
}