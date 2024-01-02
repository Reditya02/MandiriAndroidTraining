package com.example.mandiriapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mandiriapps.R
import com.example.mandiriapps.databinding.ItemMenuHomeBinding
import com.example.mandiriapps.model.MenuModel

class MenuHomeAdapter(
    private val listMenu: List<MenuModel>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<MenuHomeAdapter.ViewHolderMenu>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMenu {
        val view = ItemMenuHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        view.root.layoutParams.width = (parent.measuredWidth * 0.2).toInt()
        return ViewHolderMenu(view)
    }

    override fun onBindViewHolder(holder: ViewHolderMenu, position: Int) {
        val data = listMenu[position]
        holder.binding.apply {
            tvMenuText.text = data.menuTitle
            ivMenuIcon.setImageResource(data.image)
            root.setOnClickListener {
                onClick(data.menuTitle)
            }
        }
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }

    inner class ViewHolderMenu(val binding: ItemMenuHomeBinding) : ViewHolder(binding.root)
}