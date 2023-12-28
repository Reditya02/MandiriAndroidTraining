package com.example.mandiriapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.mandiriapps.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.apply {
            ddGender.setAdapter(ArrayAdapter(
                this@RegisterActivity,
                R.layout.list_item,
                listOf("Laki-laki", "Perempuan")
            ))

            btnRegister.setOnClickListener {
                onRegisterClicked()
            }
        }
    }

    fun onRegisterClicked() {
        binding.apply {
            val name = edtName.text.toString()
            val gender = ddGender.text.toString()
            val age = edtAge.text.toString()
            val address = edtAddres.text.toString()
            var isError = false

            tilName.error = null
            tilGender.error = null
            tilAge.error = null
            tilAddress.error = null


            if (name.isEmpty()) {
                tilName.error = "Masukkan Nama"
                isError = true
            }
            if (gender.isEmpty()) {
                tilGender.error = "Pilih Gender"
                isError = true
            }
            if (age.isEmpty()) {
                tilAge.error = "Masukkan Usia"
                isError = true
            }
            if (address.isEmpty()) {
                tilAddress.error = "Masukkan Alamat"
                isError = true
            }

            if (!isError) {
                val intent = Intent(this@RegisterActivity, ProfileActivity::class.java)
                intent.apply {
                    putExtra(KEY_NAME, name)
                    putExtra(KEY_GENDER, gender)
                    putExtra(KEY_AGE, age)
                    putExtra(KEY_ADDRESS, address)
                }
                startActivity(intent)
            }
        }
    }

    companion object {
        const val KEY_NAME = "key_name"
        const val KEY_GENDER = "key_gender"
        const val KEY_AGE = "key_age"
        const val KEY_ADDRESS = "key_address"
    }
}