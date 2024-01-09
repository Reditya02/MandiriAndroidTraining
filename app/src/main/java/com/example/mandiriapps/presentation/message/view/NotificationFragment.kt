package com.example.mandiriapps.presentation.message.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mandiriapps.adapter.NotificationAdapter
import com.example.mandiriapps.base.BaseFragment
import com.example.mandiriapps.databinding.FragmentNotificationBinding
import com.example.mandiriapps.model.NotificationModel

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        val notificationAdapter = NotificationAdapter(dummyListNotification)
        binding.rvNotification.apply {
            adapter = notificationAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private val dummyListNotification = listOf(
        NotificationModel(
            title = "Ini judul qwe",
            description = "Ini deskripsi",
            time = "12.12"
        ),
        NotificationModel(
            title = "Ini judul wer ",
            description = "Ini deskripsi",
            time = "12.12"
        ),
        NotificationModel(
            title = "Ini judul qwr",
            description = "Ini deskripsi",
            time = "12.12"
        ),
        NotificationModel(
            title = "Ini judul qwr",
            description = "Ini deskripsi",
            time = "12.12"
        ),
        NotificationModel(
            title = "Ini judul qr3",
            description = "Ini deskripsi",
            time = "12.12"
        ),
        NotificationModel(
            title = "Ini judul asf",
            description = "Ini deskripsi",
            time = "12.12"
        ),
        NotificationModel(
            title = "Ini judulsa",
            description = "Ini deskripsi",
            time = "12.12"
        ),
        NotificationModel(
            title = "Ini judul f",
            description = "Ini deskripsi",
            time = "12.12"
        ),
        NotificationModel(
            title = "Ini judul a",
            description = "Ini deskripsi",
            time = "12.12"
        ),
        NotificationModel(
            title = "Ini judulwerihweohriowreiowrihroihwerhweoihriwerwnerbwkjefbkjwfnwnfwnfnwfklnwkfnlkwnfkwfojfiwefjiwjfojwfjweoifjiwjfoiwfiooeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
            description = "Ini deskripsidsjfsdfksdjfjksdfbjsbfjkbfjsbdfjbsdjffnkjnfnsddfjknskfnjksnfjknsdfsjksdddddddddddiiweeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee",
            time = "12.12"
        ),
    )
}