package com.data.database.vocabulary

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "vocabulary_table"/*,
    foreignKeys = [
        ForeignKey(
            entity = RootVocabularyItemDB::class,
            parentColumns = ["id"],
            childColumns = ["root_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]*/
)
class VocabularyItemDB(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "root_id")
    val rootId: Int,

    @ColumnInfo(name = "vi")
    val vi: String,

    @ColumnInfo(name = "en")
    val en: String,

    @ColumnInfo(name = "type")
    val type: Int,
)