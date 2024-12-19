package ru.application.recyclerview.topic

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.application.recyclerview.R
import ru.application.recyclerview.databinding.TopicItemBinding
import ru.application.recyclerview.model.Topic

class TopicItemAdapter(context: Context) :
    ListAdapter<Topic, TopicItemAdapter.TopicViewHolder>(DiffTopicItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val binding = TopicItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return TopicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TopicViewHolder(private var binding: TopicItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(topic: Topic) {
            binding.run {
                /**
                 *  this.topic это использование переменной topic из dataBinding
                 *  TopicItemBinding <data> <variable name="topic" ... </data>,
                 *  которая является объектом 'ru.application.recyclerview.model.Topic'
                 */
                this.topic = topic
                Glide.with(topicImage)
                    .load(topic.imageUrl)
                    .placeholder(R.drawable.course_image_placeholder)
                    .into(topicImage)
            }
        }
    }

    companion object DiffTopicItemCallback : DiffUtil.ItemCallback<Topic>() {
        override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean {
            return oldItem == newItem
        }
    }

}