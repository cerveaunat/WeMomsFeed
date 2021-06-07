/*
    Author: Nathan Cerveau
    Filename: Adapter.kt
    Description: The Adapter will take the data from a WeMoms item and pass it to the ViewHolder for binding.
    The image is assigned with setImageRessource based on the generated index when the Post is created.

 */
package com.example.wemomsfeed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wemomsfeed.databinding.WemomsPostDataBinding


class DataAdapter () : ListAdapter<WeMomsPostItem, DataAdapter.DataItemViewHolder>(DataItemDiffCallback) {

    class DataItemViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val binding: WemomsPostDataBinding
        private var currentItem: WeMomsPostItem? = null

        init {
            binding = WemomsPostDataBinding.bind(itemView)
        }

        /* Bind post and image. */
        fun bind(item: WeMomsPostItem) {
            currentItem = item

            binding.apply {
                nameText.text = item.mom
                descriptionText.text = item.description
                childrenCount.text = item.children
                commentsCount.text = item.comments
                weeksOfPregnancy.text = item.weeksOfPregnancy
                likesCount.text = item.likes
                when(item.profilePictureIndex) {
                    1L -> profilePicture.setImageResource(R.drawable.picture1)
                    2L -> profilePicture.setImageResource(R.drawable.picture2)
                    3L -> profilePicture.setImageResource(R.drawable.picture3)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.wemoms_post_data, parent, false)
        return DataItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataItemViewHolder, position: Int) {
        val dataItem = getItem(position)
        holder.bind(dataItem)
    }

}

object DataItemDiffCallback : DiffUtil.ItemCallback<WeMomsPostItem>() {
    override fun areItemsTheSame(oldItem: WeMomsPostItem, newItem: WeMomsPostItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeMomsPostItem, newItem: WeMomsPostItem): Boolean {
        return oldItem.id == newItem.id
    }
}
