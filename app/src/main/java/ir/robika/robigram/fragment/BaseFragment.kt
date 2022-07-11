package ir.robika.robigram.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import ir.robika.robigram.BR
import ir.robika.robigram.viewModel.BaseViewModel
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel, VB : ViewDataBinding>(@LayoutRes val fragmentLayout: Int) :
    Fragment() {
    lateinit var viewModel: VM
        @Inject set
    lateinit var dataBinding: VB
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(layoutInflater, fragmentLayout, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.setVariable(BR.viewModel, viewModel)
        dataBinding.executePendingBindings()
        viewModel.navigationCommand.observe(viewLifecycleOwner) {
            it.navigate(activity)
        }
        initLayout()
    }

    protected abstract fun initLayout()
}