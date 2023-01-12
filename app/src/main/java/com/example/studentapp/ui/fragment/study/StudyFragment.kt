package com.example.studentapp.ui.fragment.study

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.databinding.FragmentStudyBinding
import com.example.studentapp.ui.activity.details.DetailsActivity
import com.example.studentapp.ui.adapter.StudyAdapter
import com.example.studentapp.ui.base.BaseFragment

class StudyFragment : BaseFragment<FragmentStudyBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStudyBinding =
        FragmentStudyBinding::inflate

    private val viewModel by viewModels<StudyViewModel>()

    private val adapter by lazy {
        StudyAdapter {
            val intent = Intent(requireContext(), DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.STUDY_ID, it)
            startActivity(intent)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvStudy.adapter = adapter
        binding.rvStudy.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getStudyList()

        viewModel.studyList.observe(viewLifecycleOwner) { adapter.setItems(it) }
    }
}