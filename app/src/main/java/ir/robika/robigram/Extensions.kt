package ir.robika.robigram

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil

fun <R> ViewGroup.createBindingView(@LayoutRes layout: Int): R {
    return DataBindingUtil.inflate(
        LayoutInflater.from(context),
        layout,
        this,
        false
    )
}