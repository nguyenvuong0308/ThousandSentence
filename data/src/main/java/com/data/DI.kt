package com.data

import android.content.Context
import androidx.room.Room
import com.data.database.MyDatabase
import com.data.repositoryimpl.VocabularyRepositoryImpl
import com.domain.repository.VocabularyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MyDatabase {
        return Room.databaseBuilder(context, MyDatabase::class.java, "my_database").build()
    }

    @Provides
    @Singleton
    fun provideVocabularyRepository(impl: VocabularyRepositoryImpl): VocabularyRepository {
        return impl
    }
}