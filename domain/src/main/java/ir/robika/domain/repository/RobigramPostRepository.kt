package ir.robika.domain.repository

import androidx.paging.PagingSource
import ir.robika.domain.model.CommentModel
import ir.robika.domain.model.PostModel
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getPosts(): PagingSource<Int, out PostModel>
    fun getComments(): Flow<androidx.paging.PagingData<CommentModel>>
}