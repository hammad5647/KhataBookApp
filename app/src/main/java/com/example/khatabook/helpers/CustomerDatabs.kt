package com.example.khatabook.helpers

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.khatabook.dbs.DAO
import com.example.khatabook.models.EntityModel
import com.example.khatabook.models.EntryEntity

@Database(entities = [EntityModel::class, EntryEntity::class], version = 1)

abstract class CustomerDatabs : RoomDatabase() {
    abstract fun dao(): DAO

    companion object {
        var db: CustomerDatabs? = null
        fun initDbs(context: Context): CustomerDatabs {
            if (db == null) {
                db = Room.databaseBuilder(context, CustomerDatabs::class.java, "room.db")
                    .allowMainThreadQueries().build()
            }
            return db!!
        }
    }
}