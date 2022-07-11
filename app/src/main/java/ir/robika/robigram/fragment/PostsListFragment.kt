package ir.robika.robigram.fragment

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.AndroidEntryPoint
import ir.robika.robigram.R
import ir.robika.robigram.adapter.PostPagingAdapter
import ir.robika.robigram.databinding.FragmentPostListBinding
import ir.robika.robigram.viewModel.HomeViewModel

@AndroidEntryPoint
class PostsListFragment :
    BaseFragment<HomeViewModel, FragmentPostListBinding>(R.layout.fragment_post_list) {
    val adapter = PostPagingAdapter()
    override fun initLayout() {
        dataBinding.rvPost.adapter = adapter
        viewModel.getCommentsChunk()
    }
}