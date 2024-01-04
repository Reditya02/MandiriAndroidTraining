package com.example.mandiriapps.presentation.message.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mandiriapps.R
import com.example.mandiriapps.adapter.HistoryTransactionAdapter
import com.example.mandiriapps.databinding.FragmentHistoryTransactionBinding
import com.example.mandiriapps.model.HistoryTransactionModel

class HistoryTransactionFragment : Fragment() {

    private var _binding: FragmentHistoryTransactionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRvHistoryTransaction()
    }

    private fun setupRvHistoryTransaction() {
        val adapter = HistoryTransactionAdapter(historyTransactionDummyData) {
            val intent = Intent(activity, DetailHistoryTransactionActivity::class.java)
            startActivity(intent)
        }
        binding.rcHistoryTransaction.adapter = adapter
        binding.rcHistoryTransaction.layoutManager = LinearLayoutManager(activity)
    }

    private val historyTransactionDummyData = listOf(
        HistoryTransactionModel(
            date = "12 Januari 2023",
            titleTransaction = "Transfer",
            balanceTransaction = "100000",
            subtitleTransaction = "lorem",
            iconTransaction = R.drawable.ic_baseline_mail_24,
            statusTransaction = 0
        ),
        HistoryTransactionModel(
            date = "12 Januari 2023",
            titleTransaction = "Transfer Rekening",
            balanceTransaction = "100000",
            subtitleTransaction = "lorem",
            iconTransaction = R.drawable.ic_baseline_add_24,
            statusTransaction = 2
        ),
        HistoryTransactionModel(
            date = "14 Januari 2023",
            titleTransaction = "Transfer",
            balanceTransaction = "100000",
            subtitleTransaction = "lorem",
            iconTransaction = R.drawable.ic_baseline_arrow_back_24,
            statusTransaction = 1
        ),
        HistoryTransactionModel(
            date = "12 Januari 2023",
            titleTransaction = "Transfer",
            balanceTransaction = "100000",
            subtitleTransaction = "lorem",
            iconTransaction = R.drawable.ic_baseline_credit_card_24,
            statusTransaction = 0
        ),
        HistoryTransactionModel(
            date = "12 Januari 2023",
            titleTransaction = "Transfer",
            balanceTransaction = "100000",
            subtitleTransaction = "lorem",
            iconTransaction = R.drawable.ic_baseline_person_24,
            statusTransaction = 0
        ),
        HistoryTransactionModel(
            date = "12 Januari 2023",
            titleTransaction = "Transfer",
            balanceTransaction = "100000",
            subtitleTransaction = "lorem",
            iconTransaction = R.drawable.ic_baseline_stop_circle_24,
            statusTransaction = 0
        ),
        HistoryTransactionModel(
            date = "12 Januari 2023",
            titleTransaction = "Transfer",
            balanceTransaction = "100000",
            subtitleTransaction = "lorem",
            iconTransaction = R.drawable.ic_baseline_arrow_back_24,
            statusTransaction = 0
        ),
        HistoryTransactionModel(
            date = "12 Januari 2023",
            titleTransaction = "Transfer",
            balanceTransaction = "100000",
            subtitleTransaction = "lorem",
            iconTransaction = R.drawable.ic_baseline_add_24,
            statusTransaction = 0
        ),
        HistoryTransactionModel(
            date = "12 Januari 2023",
            titleTransaction = "Transfer",
            balanceTransaction = "100000",
            subtitleTransaction = "lorem",
            iconTransaction = R.drawable.ic_baseline_add_24,
            statusTransaction = 0
        )
    )
}