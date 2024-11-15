package com.data.database.vocabulary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.reflect.Modifier

@Entity(tableName = "root_vocabulary_table")
class RootVocabularyItemDB (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "vi")
    val vi: String,

    @ColumnInfo(name = "en")
    val en: String,

    @ColumnInfo(name = "modifier")
    val modifier: Long,

    @ColumnInfo(name = "type")
    val type: Int
)