package com.example.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mandiriapps.databinding.ItemSavingBinding
import com.example.mandiriapps.model.SavingModel

class SavingAdapter : RecyclerView.Adapter<SavingAdapter.Holder>() {

    var listData = listOf<SavingModel>()

    fun setData(list: List<SavingModel>) {
        listData = list
        notifyDataSetChanged()
    }

    var showAll = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = ItemSavingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        listData.apply {
            return if (size > 2 && !showAll) 2 else size
        }
    }

    inner class Holder(private val binding: ItemSavingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SavingModel) {
            binding.apply {
                tvTitle.text = data.savingName
                tvNorek.text = data.accountNumber
                ivImage.setImageResource(data.image)
            }
        }
    }
}