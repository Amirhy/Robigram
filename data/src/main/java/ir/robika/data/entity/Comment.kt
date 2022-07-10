package ir.robika.data.entity

import androidx.room.Embedded
import androidx.room.Entity

@Entity
class Comment(@Embedded val writerUserId: Long, content: String) {
}