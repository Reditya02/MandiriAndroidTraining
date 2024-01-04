package com.example.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mandiriapps.databinding.ItemSettingsBinding
import com.example.mandiriapps.model.SettingsModel

class SettingsAdapter(
    val listData: List<SettingsModel>
) : RecyclerView.Adapter<SettingsAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = ItemSettingsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listData[position], position)
    }

    override fun getItemCount(): Int = listData.size

    class Holder(val binding: ItemSettingsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SettingsModel, pos: Int) {
            binding.apply {
                tvTitleSetting.text = data.title
                ivSettingIcon.setImageResource(data.icon)
                if (pos == 0)
                    divider.visibility = View.GONE
            }
        }
    }
}