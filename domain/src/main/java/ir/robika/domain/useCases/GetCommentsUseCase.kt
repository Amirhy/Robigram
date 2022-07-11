package ir.robika.domain.useCases

import ir.robika.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetCommentsUseCase @Inject constructor(private val repository: PostsRepository) :
    BaseUseCase<Int, Flow<*>>() {
    override suspend fun onExecute(param: Int): Flow<*> {
        return repository.getComments()
    }

}