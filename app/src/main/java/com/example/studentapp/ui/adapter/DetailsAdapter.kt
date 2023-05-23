package com.example.studentapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.R
import com.example.studentapp.databinding.ListItemDetailsBinding
import com.example.studentapp.ui.entity.StudyDetailsItem

class DetailsAdapter : RecyclerView.Adapter<DetailsAdapter.ViewHolder>() {

    private var studyList: List<StudyDetailsItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListItemDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(studyList[position])
    }

    override fun getItemCount() = studyList.size

    fun setItems(items: List<StudyDetailsItem>) {
        studyList = items
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListItemDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: StudyDetailsItem) {
            val context = binding.root.context
            val color = ContextCompat.getColor(binding.root.context, item.scoreColor)

            binding.tvWeek.text = context.getString(R.string.week, item.week)
            binding.tvSubject.text = item.subject
            binding.tvDescription.text = item.description
            binding.tvScore.text = item.score.toString()
            binding.tvScore.setTextColor(color)
            binding.tvMaxScore.text = context.getString(R.string.max_score, item.maxScore)
        }
    }
}