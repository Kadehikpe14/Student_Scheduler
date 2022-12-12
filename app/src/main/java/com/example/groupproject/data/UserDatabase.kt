package com.example.groupproject.data

import androidx.room.*
import com.example.groupproject.model.user.User

@Dao
interface UserDao{
    @Query("SELECT * FROM users WHERE users.username like :username")
    suspend fun getUser(username: String): User
    @Insert
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)
}

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun usersDao(): UserDao

}