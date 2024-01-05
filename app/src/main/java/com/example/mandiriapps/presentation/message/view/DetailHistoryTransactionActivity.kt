package com.example.mandiriapps.presentation.message.view

import android.content.Intent
import android.os.Build
import android.os.Build.VERSION
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mandiriapps.R
import com.example.mandiriapps.databinding.ActivityDetailHistoryTransactionBinding
import com.example.mandiriapps.model.HistoryTransactionModel
import com.example.mandiriapps.model.StatusTransaction

class DetailHistoryTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailHistoryTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHistoryTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<HistoryTransactionModel>(KEY_TRANSACTION)

        data?.let { bindUI(it) }


    }

    private fun bindUI(data: HistoryTransactionModel) {
        binding.apply {
            compToolbar.apply {
                tvRegister.text = "Detail"

                btnBack.setOnClickListener {
                    onBackPressed()
                }
            }
            tvStatus.text = StatusTransaction.values()[data.statusTransaction].toString()
            tvDate.text = data.date
            tvTitle.text = data.titleTransaction
            val description = " - " + data.subtitleTransaction
            tvDescription.text = description
        }
    }

    companion object {
        const val KEY_TRANSACTION = "key_transaction"
    }
}