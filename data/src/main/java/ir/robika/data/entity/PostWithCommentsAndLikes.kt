package ir.robika.data.entity

import androidx.room.Embedded
import androidx.room.Relation


data class PostWithComments(
    @Embedded val post: Post,
    @Relation(parentColumn = "id", entityColumn = "writerUserId") val comments: List<Comment>
)