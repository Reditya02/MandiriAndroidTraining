package com.example.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mandiriapps.databinding.ItemHistoryTransactionBinding
import com.example.mandiriapps.model.HisoryTransactionModel
import java.text.NumberFormat
import java.util.*

class HistoryTransactionAdapter(
    private val listData: List<HisoryTransactionModel>
) : RecyclerView.Adapter<HistoryTransactionAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = ItemHistoryTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    class Holder(val binding: ItemHistoryTransactionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: HisoryTransactionModel) {
            binding.apply {
                tvTitle.text = data.titleTransaction
                tvBalance.text = rupiah(data.balanceTransaction.toDouble())
                tvSubtitle.text = data.subtitleTransaction
                tvTime.text = data.date

            }
        }

        private fun rupiah(number: Double): String{
            val localeID =  Locale("in", "ID")
            val numberFormat = NumberFormat.getCurrencyInstance(localeID)
            return numberFormat.format(number).toString()
        }
    }

}