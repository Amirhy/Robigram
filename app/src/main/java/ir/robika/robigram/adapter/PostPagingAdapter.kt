package ir.robika.robigram.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.robika.robigram.R
import ir.robika.robigram.createBindingView
import ir.robika.robigram.databinding.ItemPostListBinding
import org.w3c.dom.Comment

class PostPagingAdapter : PagingDataAdapter<Comment, PostPagingAdapter.ViewHolder>(getDiffUtil()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.createBindingView(R.layout.item_post_list))

    class ViewHolder(private val binding: ItemPostListBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}

fun getDiffUtil(): DiffUtil.ItemCallback<Comment> {
    return object : DiffUtil.ItemCallback<Comment>() {
        override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return false
        }

        override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
            return false
        }
    }
}
