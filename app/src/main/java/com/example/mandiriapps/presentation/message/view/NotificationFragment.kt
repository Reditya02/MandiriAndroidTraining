package com.example.mandiriapps.presentation.message.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mandiriapps.adapter.NotificationAdapter
import com.example.mandiriapps.base.BaseFragment
import com.example.mandiriapps.databinding.FragmentNotificationBinding
import com.example.mandiriapps.model.NotificationModel
import com.example.mandiriapps.presentation.viewmodel.NotificationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {

    private val viewModel: NotificationViewModel by viewModels()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setData()
        viewModel.notificationData.observe(viewLifecycleOwner) {
            val notificationAdapter = NotificationAdapter(it)
            binding.rvNotification.apply {
                adapter = notificationAdapter
                layoutManager = LinearLayoutManager(activity)
            }
        }
    }


}