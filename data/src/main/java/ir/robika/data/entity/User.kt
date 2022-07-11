package ir.robika.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val userId: Int,
    val userName: String,
    val profileImageUrl: String
)