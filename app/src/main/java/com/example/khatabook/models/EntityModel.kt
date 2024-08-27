package com.example.khatabook.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Customer")
data class EntityModel(
    @PrimaryKey(true)
    var cuId: Int = 0,
    @ColumnInfo
    var cuName: String,
    @ColumnInfo
    var cuMobile: String,
    @ColumnInfo
    var cuEmail: String
) {

}