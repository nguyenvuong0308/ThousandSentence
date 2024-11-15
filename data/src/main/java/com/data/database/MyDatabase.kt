package com.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.data.database.vocabulary.RootVocabularyDao
import com.data.database.vocabulary.RootVocabularyItemDB
import com.data.database.vocabulary.VocabularyDao
import com.data.database.vocabulary.VocabularyItemDB

@Database(entities = [VocabularyItemDB::class, RootVocabularyItemDB::class], version = 1, exportSchema = true
)
abstract class MyDatabase: RoomDatabase() {
    abstract fun vocabularyDao(): VocabularyDao
    abstract fun rootVocabularyDao(): RootVocabularyDao
}