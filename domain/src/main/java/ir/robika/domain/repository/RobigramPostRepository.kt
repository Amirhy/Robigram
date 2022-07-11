package ir.robika.domain.repository

import ir.robika.domain.model.CommentModel
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    fun getComments(): Flow<androidx.paging.PagingData<CommentModel>>
}