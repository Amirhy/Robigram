package ir.robika.robigram.viewModel

import ir.robika.data.entity.Post
import ir.robika.domain.useCases.GetCommentsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val getCommentsUseCase: GetCommentsUseCase) :
    BaseViewModel() {

    fun getPostChunk(): Flow<Post> {
        return flow { }
    }

    fun getCommentsChunk() {
        launchCoroutine {
            delay(5000)
            getCommentsUseCase.apply { dispatcher = Dispatchers.IO }.execute(2)
        }
    }

}