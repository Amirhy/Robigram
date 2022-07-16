package ir.robika.data.entity

import androidx.room.Embedded
import androidx.room.Relation
import ir.robika.domain.model.PostModel


data class PostWithComments(
    @Embedded val post: Post,
    @Relation(parentColumn = "id", entityColumn = "postId") val comments: List<Comment>
) : PostModel