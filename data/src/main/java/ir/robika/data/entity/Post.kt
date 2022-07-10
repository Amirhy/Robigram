package ir.robika.data.entity

import androidx.room.Entity

@Entity
data class Post(
    val id: Long,
    val imageUrl: String,
    val caption: String,
    val submitTime: Long,
    val likeCount: Long
)