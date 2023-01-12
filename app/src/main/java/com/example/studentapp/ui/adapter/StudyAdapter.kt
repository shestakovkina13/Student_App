package com.example.studentapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.studentapp.databinding.ListItemStudyBinding
import com.example.studentapp.domain.entity.Study

class StudyAdapter(private val listener: (Int) -> Unit) :
    RecyclerView.Adapter<StudyAdapter.ViewHolder>() {

    private var studyList: List<Study> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListItemStudyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(studyList[position], listener)
    }

    override fun getItemCount() = studyList.size

    fun setItems(items: List<Study>) {
        studyList = items
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListItemStudyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Study, listener: (Int) -> Unit) {
            val color = ContextCompat.getColor(binding.root.context, item.color)

            binding.pbScore.progress = item.score
            binding.pbScore.setIndicatorColor(color)
            binding.tvScore.text = item.score.toString()
            binding.tvSubject.text = item.subject
            binding.tvType.text = item.type

            binding.root.setOnClickListener {
                listener.invoke(item.id)
            }
        }
    }
}