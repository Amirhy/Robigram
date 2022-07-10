package ir.robika.robigram.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import ir.robika.robigram.BR
import javax.inject.Inject

open class BaseActivity<VM : ViewModel, VB : ViewDataBinding?>(@LayoutRes val activityLayout: Int) :
    AppCompatActivity() {
    var viewModel: VM? = null
        @Inject set
    var dataBinding: VB? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView<VB>(this, activityLayout)
        dataBinding?.setVariable(BR.viewModel, viewModel)
        onActivityCreated()
    }

    protected fun onActivityCreated() {

    }
}