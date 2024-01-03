package com.example.mandiriapps.presentation.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mandiriapps.R
import com.example.mandiriapps.adapter.MessageTabAdapter
import com.example.mandiriapps.databinding.FragmentMessageBinding
import com.google.android.material.tabs.TabLayoutMediator

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private val TAB_TITLES = listOf(
            "History",
            "Notification"
        )
    }
}