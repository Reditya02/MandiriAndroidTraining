package com.example.mandiriapps.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mandiriapps.presentation.HomeActivity
import com.example.mandiriapps.databinding.ItemEwalletBinding
import com.example.mandiriapps.model.EWalletModel
import java.text.NumberFormat
import java.util.*

class EWalletAdapter : RecyclerView.Adapter<EWalletAdapter.Holder>() {

    private var listEWallet: MutableList<EWalletModel> = mutableListOf()

    private var _onClickEWallet: (EWalletModel) -> Unit = {}

    fun setDataEWallet(data: List<EWalletModel>) {
        this.listEWallet = data as MutableList<EWalletModel>
        notifyDataSetChanged()
    }

    fun setOnClickEWallet(listener: (EWalletModel) -> Unit) {
        _onClickEWallet = listener
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = ItemEwalletBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = listEWallet[position]
        val intent = Intent(holder.binding.root.context, HomeActivity::class.java)
        holder.binding.apply {
            ivIcon.setImageResource(data.image)
            if (data.isConnected) {
                val balance =  rupiah(data.balance)
                itemEWallet.alpha = 1f
                tvBalance.text = balance
                tvBalance.visibility = View.VISIBLE
                btnAdd.visibility = View.INVISIBLE
            } else {
                itemEWallet.alpha = 0.4f
                tvBalance.visibility = View.INVISIBLE
                btnAdd.visibility = View.VISIBLE
            }
            btnAdd.setOnClickListener {
                _onClickEWallet(data)
            }
        }
    }

    private fun rupiah(number: Double): String{
        val localeID =  Locale("in", "ID")
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)
        return numberFormat.format(number).toString()
    }

    override fun getItemCount(): Int {
        return listEWallet.size
    }

    inner class Holder(val binding: ItemEwalletBinding) : RecyclerView.ViewHolder(binding.root)
}