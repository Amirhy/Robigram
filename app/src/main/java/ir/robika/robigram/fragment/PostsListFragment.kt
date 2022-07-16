package ir.robika.robigram.fragment

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.PagerSnapHelper
import dagger.hilt.android.AndroidEntryPoint
import ir.robika.robigram.R
import ir.robika.robigram.adapter.PostPagingAdapter
import ir.robika.robigram.databinding.FragmentPostListBinding
import ir.robika.robigram.viewModel.HomeViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostsListFragment :
    BaseFragment<HomeViewModel, FragmentPostListBinding>(R.layout.fragment_post_list) {
    val adapter = PostPagingAdapter()
    override fun initLayout() {
        dataBinding.rvPost.adapter = adapter
        PagerSnapHelper().attachToRecyclerView(dataBinding.rvPost)
        viewModel.getPostChunk()
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            delay(500)
            viewModel.postFlow.collect {
                adapter.submitData(it)
            }
        }
    }
}