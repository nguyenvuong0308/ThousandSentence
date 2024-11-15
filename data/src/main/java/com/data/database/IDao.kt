package com.data.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

interface IDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<T>)

    @Delete
    suspend fun delete(item: T)
}