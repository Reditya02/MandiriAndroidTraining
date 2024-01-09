package com.example.mandiriapps.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mandiriapps.R
import com.example.mandiriapps.adapter.EWalletAdapter
import com.example.mandiriapps.adapter.MenuHomeAdapter
import com.example.mandiriapps.adapter.SavingAdapter
import com.example.mandiriapps.base.BaseFragment
import com.example.mandiriapps.databinding.FragmentHomeBinding
import com.example.mandiriapps.model.EWalletModel
import com.example.mandiriapps.model.MenuModel
import com.example.mandiriapps.model.SavingModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setupSaving()
        setupMenu()
        setupEWallet()
    }

    private fun setupEWallet() {
        val eWalletAdapter = EWalletAdapter()
        eWalletAdapter.setDataEWallet(dummyEWalletData)

        binding.apply {
            compEWallet.rvEWallet.adapter = eWalletAdapter
            eWalletAdapter.setOnClickEWallet { data ->
                dummyEWalletData.find { it == data }?.isConnected = true
                eWalletAdapter.setDataEWallet(dummyEWalletData)
            }
        }
    }

    private fun setupSaving() {
        val savingAdapter = SavingAdapter()
        savingAdapter.setData(dummySavingData)

        binding.apply {
            compSaving.rvSaving.adapter = savingAdapter

            if (savingAdapter.itemCount != dummySavingData.size) {
                showBtnShowAll(true)
            } else {
                showBtnShowAll(false)
            }

            compSaving.btnShowAll.setOnClickListener {
                showBtnShowAll(false)
                savingAdapter.showAll = true
                compSaving.rvSaving.adapter = savingAdapter
            }

            compSaving.btnShowLess.setOnClickListener {
                showBtnShowAll(true)
                savingAdapter.showAll = false
                compSaving.rvSaving.adapter = savingAdapter
            }

            if (dummySavingData.size <= 2) {
                compSaving.btnShowAll.visibility = View.GONE
                compSaving.btnShowLess.visibility = View.GONE
            }
        }
    }

    private fun setupMenu() {
        val menuAdapter = MenuHomeAdapter(dummyHomeMenuData) { text ->
            Toast.makeText(
                activity,
                text,
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.compMenuHome.gridHome.apply {
            adapter = menuAdapter
            layoutManager = GridLayoutManager(
                activity,
                2,
                RecyclerView.HORIZONTAL,
                false
            )
        }
    }

    private fun showBtnShowAll(isVisible: Boolean) {
        binding.compSaving.apply {
            if (isVisible) {
                btnShowAll.visibility = View.VISIBLE
                btnShowLess.visibility = View.GONE
            } else {
                btnShowAll.visibility = View.GONE
                btnShowLess.visibility = View.VISIBLE
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

    private val dummyHomeMenuData = listOf(
        MenuModel(image = R.drawable.li, menuTitle = "Menu 1"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 2"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 3"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 4"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 5"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 6"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 7"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 8"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 9"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 10"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 11"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 12"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 13"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 14"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 15"),
        MenuModel(image = R.drawable.li, menuTitle = "Menu 16"),
    )
}