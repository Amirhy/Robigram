package ir.robika.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import ir.robika.data.dataBase.dao.PostDao
import ir.robika.domain.model.CommentModel
import ir.robika.domain.model.PostModel
import ir.robika.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(private val dao: PostDao) : PostsRepository {
    override fun getComments(): Flow<PagingData<CommentModel>> {
//        dao.insertComment(Comment(1, 1, "1"))
        return Pager(
            PagingConfig(3),
        ) { dao.getAllComments() as PagingSource<Long, CommentModel> }.flow
    }

    override fun getPosts(): PagingSource<Int, out PostModel> {
        return dao.getPostsWithCommentsTest()
    }
}