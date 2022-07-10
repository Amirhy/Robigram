package ir.robika.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.robika.data.entity.Post
import ir.robika.data.entity.User

@Database(version = 1, entities = [Post::class, User::class])
abstract class AppDataBase : RoomDatabase() {
}