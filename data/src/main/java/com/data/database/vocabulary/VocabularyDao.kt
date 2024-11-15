package com.data.database.vocabulary

import androidx.room.Dao
import androidx.room.Query
import com.data.database.IDao
import kotlinx.coroutines.flow.Flow

@Dao
interface VocabularyDao: IDao<VocabularyItemDB> {
    @Query("SELECT * FROM vocabulary_table")
    fun getAllVocabulary(): Flow<List<VocabularyItemDB>>

    @Query("SELECT * FROM vocabulary_table WHERE root_id = :rootId AND type = :type")
    fun getVocabularyByRootId(rootId: Int, type: Int): Flow<List<VocabularyItemDB>>
}