package ir.robika.robigram.viewModel

import androidx.lifecycle.viewModelScope
import androidx.paging.*
import ir.robika.data.entity.CommentWithUser
import ir.robika.data.entity.PostWithComments
import ir.robika.domain.useCases.GetCommentsUseCase
import ir.robika.domain.useCases.GetPostsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getCommentsUseCase: GetCommentsUseCase,
    private val getPostsUseCase: GetPostsUseCase
) :
    BaseViewModel() {
    var flow = emptyFlow<PagingData<CommentWithUser>>()
    var postFlow = emptyFlow<PagingData<PostWithComments>>()
    fun getPostChunk() {
        launchCoroutine {
            val postData =
                (getPostsUseCase.apply { dispatcher = Dispatchers.IO }
                    .execute(null)) as PagingSource<Int, PostWithComments>
            postFlow = Pager(PagingConfig(5)) {
                postData
            }.flow.cachedIn(viewModelScope)
        }
    }

    fun getCommentsChunk() {
        launchCoroutine {
            flow = getCommentsUseCase.apply { dispatcher = Dispatchers.IO }
                .execute(2) as Flow<PagingData<CommentWithUser>>
        }
    }

}