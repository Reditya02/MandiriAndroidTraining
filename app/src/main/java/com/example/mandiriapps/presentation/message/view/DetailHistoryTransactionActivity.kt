package com.example.mandiriapps.presentation.message.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mandiriapps.R
import com.example.mandiriapps.databinding.ActivityDetailHistoryTransactionBinding

class DetailHistoryTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailHistoryTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHistoryTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.compToolbar.apply {
            tvRegister.text = "Detail"
            btnBack.setOnClickListener {
                onBackPressed()
            }
        }
    }
}