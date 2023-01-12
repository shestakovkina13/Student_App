package com.example.studentapp.ui.fragment.debt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentapp.databinding.FragmentDebtBinding
import com.example.studentapp.ui.adapter.StudyAdapter
import com.example.studentapp.ui.base.BaseFragment

class DebtFragment : BaseFragment<FragmentDebtBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDebtBinding =
        FragmentDebtBinding::inflate

    private val viewModel by viewModels<DebtViewModel>()

    private val adapter by lazy { StudyAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvStudy.adapter = adapter
        binding.rvStudy.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getStudyList()

        viewModel.studyList.observe(viewLifecycleOwner) {
            adapter.setItems(it)
            binding.tvNoDebts.visibility = if (it.isEmpty()) View.VISIBLE else View.GONE
        }
    }
}