package ir.robika.data.dataBase.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import ir.robika.data.entity.*

@Dao
interface PostDao {
    @Insert(onConflict = REPLACE)
    fun insertComment(comment: Comment)

    @Insert(onConflict = REPLACE)
    fun insertPost(comment: Post)

    @Insert(onConflict = REPLACE)
    fun insertUser(comment: User)

    @Query("select * from user,comment where userId=writerUserId ")
    @Transaction
    fun getAllComments(): PagingSource<Int, CommentWithUser>

    @Query("select * from user,comment where userId=writerUserId ")
    @Transaction
    fun getAllCommentsTest(): List<CommentWithUser>

    /*   @Query("select * from user,post,comment where postId=id ")
       @Transaction
       fun getAllPost(): PagingSource<Int, PostWithComments>
   */
    /*@Query("select * from post left join comment on post.id=comment.postId ")
    @Transaction
    fun getPostsWithComments(): PagingSource<Int, Map<Post, List<Comment>>>*/

    @Query("select * from post")
    @Transaction
    fun getPostsWithCommentsTest(): PagingSource<Int, PostWithComments>
}
