package com.data.database.vocabulary

import androidx.room.Dao
import androidx.room.Query
import com.data.database.IDao
import kotlinx.coroutines.flow.Flow

@Dao
interface RootVocabularyDao: IDao<RootVocabularyItemDB> {
    @Query("SELECT * FROM root_vocabulary_table")
    fun getAllVocabulary(): Flow<List<RootVocabularyItemDB>>

    @Query("SELECT * FROM root_vocabulary_table WHERE id = :rootId")
    fun getRootVocabularyById(rootId: Int): Flow<RootVocabularyItemDB?>
}