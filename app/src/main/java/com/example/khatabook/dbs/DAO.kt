package com.example.khatabook.dbs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.khatabook.models.EntityModel
import com.example.khatabook.models.EntryEntity

@Dao
interface DAO {

    @Insert
    fun customerInsertData(model: EntityModel)

    @Update
    fun customerUpdateData(model: EntityModel)

    @Delete
    fun customerDeleteData(model: EntityModel)

    @Query("SELECT * FROM Customer")
    fun customerReadData(): MutableList<EntityModel>

    @Insert
    fun entryInsertData(model: EntryEntity)

    @Update
    fun entryUpdateData(model: EntryEntity)

    @Delete
    fun entryDelete(model: EntryEntity)

    @Query("SELECT * FROM Entry")
    fun entryReadData(): MutableList<EntryEntity>


}