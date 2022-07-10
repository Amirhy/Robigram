package ir.robika.robigram.activity

import dagger.hilt.android.AndroidEntryPoint
import ir.robika.robigram.R
import ir.robika.robigram.databinding.ActivityMainBinding
import ir.robika.robigram.viewModel.HomeViewModel

@AndroidEntryPoint
class HomeActivity : BaseActivity<HomeViewModel, ActivityMainBinding>(R.layout.activity_main) {

}