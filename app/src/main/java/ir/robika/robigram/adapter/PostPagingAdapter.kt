package ir.robika.robigram.adapter

import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.robika.data.entity.PostWithComments
import ir.robika.robigram.R
import ir.robika.robigram.createBindingView
import ir.robika.robigram.databinding.ItemPostListBinding

class PostPagingAdapter :
    PagingDataAdapter<PostWithComments, PostPagingAdapter.ViewHolder>(getDiffUtil()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemToBind = getItem(position)
        holder.binding.postItem = itemToBind
        holder.binding.userItem = itemToBind?.post?.owner
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.createBindingView(R.layout.item_post_list))

    class ViewHolder(val binding: ItemPostListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                it.findNavController()
                    .navigate(R.id.action_postsListFragment_to_commentsLDetailFragment)
            }
        }
    }
}

fun getDiffUtil(): DiffUtil.ItemCallback<PostWithComments> {
    return object : DiffUtil.ItemCallback<PostWithComments>() {
        override fun areContentsTheSame(
            oldItem: PostWithComments,
            newItem: PostWithComments
        ): Boolean {
            return false
        }

        override fun areItemsTheSame(
            oldItem: PostWithComments,
            newItem: PostWithComments
        ): Boolean {
            return false
        }
    }
}
