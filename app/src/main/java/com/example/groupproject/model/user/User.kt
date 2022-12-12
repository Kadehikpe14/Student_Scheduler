package com.example.groupproject.model.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class User(
    @PrimaryKey
    val username: String,
    @ColumnInfo
    val password: String,
    @ColumnInfo
    val TUID: String
){
    constructor(): this("","","")
}