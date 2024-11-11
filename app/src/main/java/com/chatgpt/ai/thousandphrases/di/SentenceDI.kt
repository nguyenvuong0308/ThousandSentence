package com.chatgpt.ai.thousandphrases.di

import com.chatgpt.ai.thousandphrases.presentation.main.viewmodel.MainViewModel
import com.chatgpt.ai.thousandphrases.presentation.main.viewmodel.MainViewModelInterface
import com.data.repositoryimpl.SentenceRepositoryImpl
import com.domain.repository.SentenceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SentenceDI {
    @Provides
    @Singleton
    fun provideSentenceRepository(sentenceRepositoryImpl: SentenceRepositoryImpl): SentenceRepository = sentenceRepositoryImpl
}


@Module
@InstallIn(SingletonComponent::class)
class ViewModelDI {

    @Provides
    @Singleton
    fun provideMainViewModel(viewModel: MainViewModel): MainViewModelInterface = viewModel

}
