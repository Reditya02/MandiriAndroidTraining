package com.example.mandiriapps.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.example.mandiriapps.R
import com.example.mandiriapps.databinding.DialogLayoutBinding

class ConfirmationDialogUtil(private val context: Context) {
    fun showConfirmationDialog(
        title: String,
        message: String = "",
        onConfirm: () -> Unit,
        onCancel: () -> Unit
    ) {
        val dialogBuilder = AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null)
        val dialogBinding = DialogLayoutBinding.bind(dialogView)

        dialogBinding.tvMessage.text = title

        alertDialog.setView(dialogView)

        dialogBinding.btnPositive.setOnClickListener {
            onConfirm()
            alertDialog.dismiss()
        }

        dialogBinding.btnNegative.setOnClickListener {
            onCancel()
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}