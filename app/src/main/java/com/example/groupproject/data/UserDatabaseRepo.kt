package com.example.groupproject.data

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.groupproject.model.user.User


class UserDatabaseRepo(app: Context) {

    private val db: UserDatabase

    init {

        db = Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            "user.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    suspend fun getUser(username: String){
        return db.usersDao().getUser(username)
    }
    suspend fun addUser(user: User){
        return db.usersDao().addUser(user)
    }
    suspend fun updateUser(user: User){
        return db.usersDao().updateUser(user)
    }
}