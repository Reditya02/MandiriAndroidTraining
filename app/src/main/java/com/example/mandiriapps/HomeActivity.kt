package com.example.mandiriapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        adapter.setDataEWallet(listOf(
            EWalletModel(image = R.drawable.ic_baseline_add_24),
            EWalletModel(image = R.drawable.ic_baseline_arrow_back_24),
            EWalletModel(image = R.drawable.ic_baseline_mail_24),
            EWalletModel(image = R.drawable.ic_bg),
            ))

        binding.apply {
            compEWallet.rvEWallet.adapter = adapter
        }

    }
}