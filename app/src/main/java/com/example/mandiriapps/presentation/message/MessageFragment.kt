package com.example.mandiriapps.presentation.message

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mandiriapps.adapter.MessageTabAdapter
import com.example.mandiriapps.base.BaseFragment
import com.example.mandiriapps.databinding.FragmentMessageBinding
import com.google.android.material.tabs.TabLayoutMediator

class MessageFragment : BaseFragment<FragmentMessageBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setupTabView()
    }

    private fun setupTabView() {
        val adapter = MessageTabAdapter(this)
        binding.apply {
            vpMessage.adapter = adapter
            TabLayoutMediator(tabMessage, vpMessage) { tab, position ->
                tab.text = TAB_TITLES[position]
            }.attach()
        }
    }

    companion object {
        private val TAB_TITLES = listOf(
            "History",
            "Notification"
        )
    }
}