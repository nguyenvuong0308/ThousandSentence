package com.chatgpt.ai.thousandphrases.di

import com.data.repositoryimpl.SentenceRepositoryImpl
import com.domain.repository.SentenceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SentenceDI {
    @Provides
    @Singleton
    fun provideSentenceRepository(sentenceRepositoryImpl: SentenceRepositoryImpl): SentenceRepository = sentenceRepositoryImpl

}