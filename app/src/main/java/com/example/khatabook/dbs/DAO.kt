package com.example.khatabook.dbs

import androidx.annotation.RequiresPermission
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.khatabook.models.EntityModel

@Dao
interface DAO {
    @Insert
    fun insertData(model: EntityModel)

    @Update
    fun updateData(model: EntityModel)

    @Delete
    fun deleteData(model: EntityModel)

    @Query("SELECT * FROM Customer ")
    fun readData(): MutableList<EntityModel>
}