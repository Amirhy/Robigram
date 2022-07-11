package ir.robika.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.robika.domain.model.CommentModel

@Entity
data class Comment(val writerUserId: Int, @PrimaryKey val id: Int, val content: String) :
    CommentModel() {
}