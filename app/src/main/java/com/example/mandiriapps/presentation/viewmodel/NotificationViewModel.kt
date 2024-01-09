package com.example.mandiriapps.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mandiriapps.model.NotificationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor() : ViewModel() {
    private val  _notificationData = MutableLiveData<List<NotificationModel>>()
    val notificationData: LiveData<List<NotificationModel>> = _notificationData

    fun setData() {
        _notificationData.postValue(dummyListNotification)
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