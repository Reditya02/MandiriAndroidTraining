package com.example.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mandiriapps.databinding.ItemNotificationBinding
import com.example.mandiriapps.model.NotificationModel

class NotificationAdapter(
    private val listNotification: List<NotificationModel>
) : RecyclerView.Adapter<NotificationAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = ItemNotificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = listNotification[position]
        holder.binding.apply {
            tvTitle.text = data.title
            tvDescription.text = data.description
            tvTime.text = data.time
        }
    }

    override fun getItemCount(): Int = listNotification.size

    class Holder(val binding: ItemNotificationBinding) : RecyclerView.ViewHolder(binding.root)
}