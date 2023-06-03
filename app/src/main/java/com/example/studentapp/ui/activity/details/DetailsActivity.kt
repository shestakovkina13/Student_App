package com.example.studentapp.ui.activity.details

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.databinding.ActivityDetailsBinding
import com.example.studentapp.ui.adapter.DetailsAdapter
import com.example.studentapp.utils.mapStudyDetails

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val viewModel by viewModels<DetailsViewModel>()
//lazy - ленивая инициализация (происходит, когда объект будет вызван первый раз)
    private val adapter by lazy { DetailsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//binding - создаёт экземпляр layout, генерирует код для view
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.getDetails(intent.getIntExtra(STUDY_ID, -1))
//observe - при изменении состояния объекта переходит в callback
        viewModel.details.observe(this) {
            title = it.subject
            binding.tvForm.text = it.form
            binding.tvTeacherName.text = it.teacherName
            binding.tvDepartment.text = it.department
            adapter.setItems(mapStudyDetails(it.studyDetailsList))
        }

        binding.rvDetails.adapter = adapter
        binding.rvDetails.layoutManager = LinearLayoutManager(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val STUDY_ID = "STUDY_ID"
    }
}