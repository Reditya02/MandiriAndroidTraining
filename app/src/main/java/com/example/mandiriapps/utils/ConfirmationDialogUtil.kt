package com.example.mandiriapps.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.mandiriapps.R
import com.example.mandiriapps.databinding.DialogLayoutBinding

class ConfirmationDialogUtil(private val context: Context) {
    fun showConfirmationDialog(
        title: String,
        icon : Int?= null,
        onConfirm: () -> Unit,
        onCancel: () -> Unit
    ) {
        val dialogBuilder = AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null)
        val dialogBinding = DialogLayoutBinding.bind(dialogView)
        alertDialog.setView(dialogView)

        dialogBinding.apply {
            tvMessage.text = title

            icon?.let {
                ivIcon.apply {
//                    setAnimation(it)
                    setImageResource(it)
                    visibility = View.VISIBLE
                }
            }

            btnPositive.setOnClickListener {
                onConfirm()
                alertDialog.dismiss()
            }

            btnNegative.setOnClickListener {
                onCancel()
                alertDialog.dismiss()
            }
        }
        alertDialog.show()
    }
}