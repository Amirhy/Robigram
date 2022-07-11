package ir.robika.robigram.fragment

import dagger.hilt.android.AndroidEntryPoint
import ir.robika.robigram.R
import ir.robika.robigram.databinding.FragmentCommentsDetailBinding
import ir.robika.robigram.viewModel.HomeViewModel
@AndroidEntryPoint
class CommentsLDetailFragment :
    BaseFragment<HomeViewModel, FragmentCommentsDetailBinding>(R.layout.fragment_comments_detail) {
    override fun initLayout() {

    }
}