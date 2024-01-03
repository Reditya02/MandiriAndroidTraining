package com.example.mandiriapps.presentation.message.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.mandiriapps.R
import com.example.mandiriapps.adapter.NotificationAdapter
import com.example.mandiriapps.databinding.FragmentNotificationBinding
import com.example.mandiriapps.model.NotificationModel

class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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