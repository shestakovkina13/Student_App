package com.example.studentapp.ui.fragment.study

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.databinding.FragmentStudyBinding
import com.example.studentapp.ui.adapter.StudyAdapter
import com.example.studentapp.ui.base.BaseFragment

class StudyFragment : BaseFragment<FragmentStudyBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStudyBinding =
        FragmentStudyBinding::inflate

    private val viewModel by viewModels<StudyViewModel>()

    private val adapter by lazy { StudyAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvStudy.adapter = adapter
        binding.rvStudy.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getStudyList()

        viewModel.studyList.observe(viewLifecycleOwner) { adapter.setItems(it) }
    }
}