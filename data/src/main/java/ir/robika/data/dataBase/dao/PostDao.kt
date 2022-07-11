package ir.robika.data.dataBase.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import ir.robika.data.entity.Comment
import ir.robika.data.entity.CommentWithUser

@Dao
interface PostDao {
/*
     @Query("select * from post")
     fun getAllPost(): Flow<List<Post>>

     @Query("select * from post order by submitTime limit :pageCount")
     fun getPostPaged(pageCount: String): PagingSource<Int, PostWithComments>
*/

    @Insert
    fun insertComment(comment: Comment)

    @Query("select * from Comment ")
    @Transaction
    fun getAllComments(): PagingSource<Int, CommentWithUser>
}