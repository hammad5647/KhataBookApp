package com.example.khatabook.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
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
    var cuFlat: String,
    @ColumnInfo
    var cuArea: String,
    @ColumnInfo
    var cuState: String,
    @ColumnInfo
    var cuCity: String,
    @ColumnInfo
    var cuPincode: String

)

@Entity(
    tableName = "Entry",
    foreignKeys = [ForeignKey(
        entity = EntityModel::class,
        parentColumns = ["cuId"],
        childColumns = ["customerIDEntry"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class EntryEntity(
    @PrimaryKey(autoGenerate = true)
    var idEntry: Int = 0,
    @ColumnInfo
    var customerIDEntry: Int = 0,
    @ColumnInfo
    var productNameEntry: String,
    @ColumnInfo
    var productQuantityEntry: String,
    @ColumnInfo
    var productRateEntry: String,
    @ColumnInfo
    var productAmountEntry: String,
    @ColumnInfo
    var productTypeEntry: Int,
    @ColumnInfo
    var productDateEntry: String,
    @ColumnInfo
    var productCollectEntry: String

)

data class TransactionEntity(
    @PrimaryKey(true)
    var cuId: Int = 0,
    @ColumnInfo
    var cuName: String,
    @ColumnInfo
    var cuMobile: String,
    @ColumnInfo
    var cuFlat: String,
    @ColumnInfo
    var cuArea: String,
    @ColumnInfo
    var cuState: String,
    @ColumnInfo
    var cuCity: String,
    @ColumnInfo
    var cuPincode: String,

    @PrimaryKey(true)
    var traId: Int = 0,
    @ColumnInfo
    var traCustomerId: Int = 0,
    @ColumnInfo
    var traProductName: String,
    @ColumnInfo
    var traQuantity: String,
    @ColumnInfo
    var traRate: String,
    @ColumnInfo
    var traAMount: String,
    @ColumnInfo
    var traType: Int,
    @ColumnInfo
    var traCollectDate: String,
    @ColumnInfo
    var traDate: String

)


