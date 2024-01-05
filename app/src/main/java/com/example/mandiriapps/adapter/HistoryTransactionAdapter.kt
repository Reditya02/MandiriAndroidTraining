package com.example.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mandiriapps.R
import com.example.mandiriapps.databinding.ItemHistoryTransactionBinding
import com.example.mandiriapps.model.HistoryTransactionModel
import com.example.mandiriapps.model.StatusTransaction
import java.text.NumberFormat
import java.util.*

class HistoryTransactionAdapter(
    private var listData: List<HistoryTransactionModel>,
    private val onClick: (HistoryTransactionModel) -> Unit
) : RecyclerView.Adapter<HistoryTransactionAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = ItemHistoryTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(listData[position])
        holder.binding.root.setOnClickListener{ onClick(listData[position]) }
    }

    override fun getItemCount(): Int = listData.size

    fun filterTransactionData(updatedData: List<HistoryTransactionModel>) {
        listData = updatedData
        notifyDataSetChanged()
    }

    class Holder(val binding: ItemHistoryTransactionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: HistoryTransactionModel) {
            binding.apply {
                tvTitle.text = data.titleTransaction
                tvBalance.text = rupiah(data.balanceTransaction.toDouble())
                tvSubtitle.text = data.subtitleTransaction
                tvTime.text = data.date
                ivIcon.setImageResource(data.iconTransaction)

                tvStatus.apply {
                    when (data.statusTransaction) {
                        StatusTransaction.Berhasil.value -> {
                            text = "Berhasil"
                            setTextColor(binding.root.context.resources.getColor(R.color.green))
                        }
                        StatusTransaction.Gagal.value -> {
                            text = "Gagal"
                            setTextColor(binding.root.context.resources.getColor(R.color.red))
                        }
                        StatusTransaction.Pending.value -> {
                            text = "Pending"
                            setTextColor(binding.root.context.resources.getColor(R.color.purple_500))
                        }
                        else -> {
                            text = "Pending"
                            setTextColor(binding.root.context.resources.getColor(R.color.purple_500))
                        }
                    }
                }

            }
        }

        private fun rupiah(number: Double): String{
            val localeID =  Locale("in", "ID")
            val numberFormat = NumberFormat.getCurrencyInstance(localeID)
            return numberFormat.format(number).toString()
        }
    }

}