package com.example.mandiriapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.mandiriapps.adapter.EWalletAdapter
import com.example.mandiriapps.databinding.ActivityHomeBinding
import com.example.mandiriapps.model.EWalletModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = EWalletAdapter()

        val dummyData = mutableListOf(
            EWalletModel(image = R.drawable.li, balance = 2000000.0, isConnected = true),
            EWalletModel(image = R.drawable.orang_lari),
            EWalletModel(image = R.drawable.logo_bank_mandiri, balance = 5600000.0, isConnected = true),
            EWalletModel(image = R.drawable.li),
        )

        adapter.setDataEWallet(dummyData)

        binding.apply {
            compEWallet.rvEWallet.adapter = adapter
            adapter.setOnClickEWallet { data ->
                dummyData.find { it == data }?.isConnected = true
                adapter.setDataEWallet(dummyData)
            }
        }

    }
}