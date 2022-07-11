package ir.robika.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey
    val id: Int,
    val imageUrl: String,
    val caption: String,
    val submitTime: Long,
    val likeCount: Long
)