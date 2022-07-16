package ir.robika.data.entity

import androidx.room.Embedded
import androidx.room.Relation
import ir.robika.domain.model.CommentModel

data class CommentWithUser(
    @Embedded val user: User,
    @Relation(entityColumn = "writerUserId", parentColumn = "userId") val comment: Comment
) : CommentModel

