package com.example.khatabook.helpers

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.khatabook.dbs.DAO
import com.example.khatabook.models.EntityModel

@Database(entities = [EntityModel::class], version = 1)

abstract class CustomerDatabs : RoomDatabase() {

    abstract fun dao(): DAO

    companion object {

        private var cuData: CustomerDatabs? = null

        fun initDbs(context: Context): CustomerDatabs {
            if (cuData == null) {
                cuData = Room.databaseBuilder(context, CustomerDatabs::class.java, "room.db")
                    .allowMainThreadQueries().build()
            }
            return cuData!!
        }
    }
}