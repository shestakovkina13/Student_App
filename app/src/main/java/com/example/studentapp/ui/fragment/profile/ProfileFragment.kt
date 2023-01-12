package com.example.studentapp.ui.fragment.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.studentapp.ui.activity.LoginActivity
import com.example.studentapp.databinding.FragmentProfileBinding
import com.example.studentapp.ui.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProfileBinding =
        FragmentProfileBinding::inflate

    private val viewModel by viewModels<ProfileViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getProfile()

        viewModel.profile.observe(viewLifecycleOwner) {
            binding.pbScore.progress = it.semesterProgress
            binding.tvScore.text = it.semesterValue.toString()
            binding.tvUsername.text = it.username
            binding.tvWeek.text = it.week
            binding.tvGroup.text = it.group
            binding.tvId.text = it.id.toString()
        }

        binding.btnExit.setOnClickListener {
            requireActivity().apply {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }
}