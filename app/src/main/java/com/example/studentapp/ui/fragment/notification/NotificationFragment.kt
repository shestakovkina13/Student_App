package com.example.studentapp.ui.fragment.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studentapp.databinding.FragmentNotificationBinding
import com.example.studentapp.ui.base.BaseFragment
import com.example.studentapp.utils.showCheckNotification
import com.example.studentapp.utils.showRetakeNotification
import com.example.studentapp.utils.showScheduleBehindNotification

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNotificationBinding =
        FragmentNotificationBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvRetake.setOnClickListener { showRetakeNotification(requireContext()) }
        binding.tvCheck.setOnClickListener { showCheckNotification(requireContext()) }
        binding.tvScheduleBehind.setOnClickListener { showScheduleBehindNotification(requireContext()) }
    }
}