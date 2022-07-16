package ir.robika.robigram

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:loadImageUrl")
fun loadImageUrl(view: ImageView, url: String) {
    Glide.with(view).load(url).centerCrop().into(view)
}

@BindingAdapter("app:loadImageUrlCircleCrop")
fun loadImageUrlCircleCrop(view: ImageView, url: String) {
    Glide.with(view).load(url).circleCrop().into(view)
}