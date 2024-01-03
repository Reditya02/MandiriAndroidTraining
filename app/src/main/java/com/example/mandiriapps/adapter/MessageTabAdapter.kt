package com.example.mandiriapps.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mandiriapps.presentation.message.MessageFragment
import com.example.mandiriapps.presentation.message.view.HistoryTransactionFragment
import com.example.mandiriapps.presentation.message.view.NotificationFragment

class MessageTabAdapter(
    fragment: Fragment
) : FragmentStateAdapter(
    fragment.childFragmentManager,
    fragment.lifecycle
) {

    private val fragmentContent = mutableListOf<Fragment>()

    private val listFragment = listOf(
        fragmentContent.add(fragment)
    )

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var selectedFragment: Fragment? = null
        when (position) {
            0 -> selectedFragment = HistoryTransactionFragment()
            1 -> selectedFragment = NotificationFragment()
        }
        return selectedFragment as Fragment
    }
}