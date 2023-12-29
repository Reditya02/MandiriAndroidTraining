package com.example.mandiriapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mandiriapps.adapter.EWalletAdapter
import com.example.mandiriapps.adapter.SavingAdapter
import com.example.mandiriapps.databinding.ActivityHomeBinding
import com.example.mandiriapps.model.EWalletModel
import com.example.mandiriapps.model.SavingModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val eWalletAdapter = EWalletAdapter()
        eWalletAdapter.setDataEWallet(dummyEWalletData)

        val savingAdapter = SavingAdapter()
        savingAdapter.setData(dummySavingData)

        binding.apply {
            compEWallet.rvEWallet.adapter = eWalletAdapter
            eWalletAdapter.setOnClickEWallet { data ->
                dummyEWalletData.find { it == data }?.isConnected = true
                eWalletAdapter.setDataEWallet(dummyEWalletData)
            }

            compSaving.rvSaving.adapter = savingAdapter

            if (savingAdapter.itemCount != dummySavingData.size) {
                compSaving.btnShowAll.visibility = View.VISIBLE
            } else {
                compSaving.btnShowAll.visibility = View.GONE
            }

            compSaving.btnShowAll.setOnClickListener {
                compSaving.btnShowAll.visibility = View.GONE
                savingAdapter.showAll = true
                compSaving.rvSaving.adapter = savingAdapter
            }
        }

    }

    private val dummyEWalletData = mutableListOf(
        EWalletModel(image = R.drawable.li, balance = 2000000.0, isConnected = true),
        EWalletModel(image = R.drawable.orang_lari),
        EWalletModel(image = R.drawable.logo_bank_mandiri, balance = 5600000.0, isConnected = true),
        EWalletModel(image = R.drawable.li),
    )

    private val dummySavingData = listOf(
        SavingModel(savingName = "Tabungan A", accountNumber = "12345678", image = R.drawable.ic_cropped_card),
        SavingModel(savingName = "Tabungan B", accountNumber = "1893409", image = R.drawable.ic_cropped_card),
        SavingModel(savingName = "Tabungan C", accountNumber = "1893409", image = R.drawable.ic_cropped_card),
        SavingModel(savingName = "Tabungan D", accountNumber = "1893409", image = R.drawable.ic_cropped_card),
        )
}