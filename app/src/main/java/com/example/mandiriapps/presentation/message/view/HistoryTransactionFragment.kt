package com.example.mandiriapps.presentation.message.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mandiriapps.R
import com.example.mandiriapps.adapter.HistoryTransactionAdapter
import com.example.mandiriapps.databinding.FragmentHistoryTransactionBinding
import com.example.mandiriapps.model.HistoryTransactionModel
import com.example.mandiriapps.model.StatusTransaction
import com.example.mandiriapps.utils.ConfirmationDialogUtil

class HistoryTransactionFragment : Fragment() {

    private lateinit var historyAdapter: HistoryTransactionAdapter

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
        val listItem = mutableListOf<String>()
        listItem.add("Semua")
        StatusTransaction.values().forEach {
            listItem.add(it.toString())
        }


        binding.spFilterTransaction.apply {
            adapter = ArrayAdapter(requireContext(), R.layout.list_item, listItem)
            onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (position > 0) {
                        val spValue: Int = position - 1
                        historyTransactionDummyData.filter {
                            it.statusTransaction == spValue
                        }.also {
                            historyAdapter.filterTransactionData(it)
                        }
                    } else {
                        historyAdapter.filterTransactionData(historyTransactionDummyData)
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
        }
    }

    private fun setupRvHistoryTransaction() {
        historyAdapter = HistoryTransactionAdapter(historyTransactionDummyData) {
            val dialog = ConfirmationDialogUtil(requireContext())
            dialog.showConfirmationDialog(
                title = it.titleTransaction,
                icon = it.iconTransaction,
                onConfirm = { toDetailTransaction(it) },
                onCancel = {}
            )
        }
        binding.rcHistoryTransaction.adapter = historyAdapter
        binding.rcHistoryTransaction.layoutManager = LinearLayoutManager(activity)
    }

    private fun toDetailTransaction(data: HistoryTransactionModel) {
        val intent = Intent(activity, DetailHistoryTransactionActivity::class.java)
        intent.putExtra(DetailHistoryTransactionActivity.KEY_TRANSACTION, data)
        startActivity(intent)
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