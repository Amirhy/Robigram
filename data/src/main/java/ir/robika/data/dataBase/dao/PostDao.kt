package ir.robika.data.dataBase.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import ir.robika.data.entity.Post
import ir.robika.data.entity.PostWithComments
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {
    @Query("select * from post")
    fun getAllPost(): Flow<List<Post>>

    @Query("select * from post order by submitTime limit :pageCount")
    fun getPostPaged(pageCount: String): PagingSource<Long, PostWithComments>
}