package com.example.studentapp.ui.activity.details

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.databinding.ActivityDetailsBinding
import com.example.studentapp.ui.adapter.DetailsAdapter

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val viewModel by viewModels<DetailsViewModel>()

    private val adapter by lazy { DetailsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getDetails(intent.getIntExtra(STUDY_ID, -1))

        viewModel.details.observe(this) {
            title = it.subject
            binding.tvForm.text = it.form
            binding.tvTeacherName.text = it.teacherName
            binding.tvDepartment.text = it.department
            adapter.setItems(it.studyDetailsList)
        }

        binding.rvDetails.adapter = adapter
        binding.rvDetails.layoutManager = LinearLayoutManager(this)
    }

    companion object {
        const val STUDY_ID = "STUDY_ID"
    }
}