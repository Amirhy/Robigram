package ir.robika.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import ir.robika.data.dataBase.dao.PostDao
import ir.robika.data.entity.Comment
import ir.robika.data.entity.User
import ir.robika.domain.model.CommentModel
import ir.robika.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(private val dao: PostDao) : PostsRepository {
    override fun getComments(): Flow<PagingData<CommentModel>> {
        dao.insertComment(Comment(User(1,"a","a"),1,"1"))
        return Pager(
            PagingConfig(5),
        ) { dao.getAllComments() as PagingSource<Long, CommentModel> }.flow
    }
}