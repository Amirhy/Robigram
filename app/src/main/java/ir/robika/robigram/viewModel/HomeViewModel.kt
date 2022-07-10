package ir.robika.robigram.viewModel

import ir.robika.data.entity.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel() {
    fun getPostChunk(): Flow<Post> {
        return flow { }
    }

}