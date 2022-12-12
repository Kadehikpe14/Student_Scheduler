package com.example.groupproject.data

import androidx.room.*
import com.example.groupproject.model.user.User

//import edu.towson.cosc435.michael.project2.models.user.User

//TODO does dao need to be suspend?
@Dao
interface UserDao{
    @Query("SELECT * FROM users WHERE username = users.username")
    suspend fun getUser(username: String)
    @Insert
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)
}
//TODO() figure out this shit for database
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun usersDao(): UserDao

}