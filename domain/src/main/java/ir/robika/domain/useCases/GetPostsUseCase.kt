package ir.robika.domain.useCases

import androidx.paging.PagingSource
import ir.robika.domain.model.PostModel
import ir.robika.domain.repository.PostsRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(val repository: PostsRepository) :
    BaseUseCase<Void?, PagingSource<Int, out PostModel>>() {

    override suspend fun onExecute(param: Void?): PagingSource<Int,out PostModel> {
        return repository.getPosts()
    }
}