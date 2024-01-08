package com.example.mandiriapps.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.mandiriapps.R
import com.example.mandiriapps.presentation.RegisterActivity.Companion.KEY_ADDRESS
import com.example.mandiriapps.presentation.RegisterActivity.Companion.KEY_AGE
import com.example.mandiriapps.presentation.RegisterActivity.Companion.KEY_GENDER
import com.example.mandiriapps.presentation.RegisterActivity.Companion.KEY_NAME
import com.example.mandiriapps.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(KEY_NAME)
        val age = intent.getStringExtra(KEY_AGE)
        val address = intent.getStringExtra(KEY_ADDRESS)
        val gender = intent.getStringExtra(KEY_GENDER)

        Glide.with(this)
            .load("https://images.bisnis.com/posts/2022/02/25/1504876/logo-livin.jpg")
            .circleCrop()
            .into(binding.ivProfile)

        binding.apply {
            edtName.setText(name)
            edtAge.setText(age)
            edtAddres.setText(address)
            ddGender.setText(gender)

            ddGender.setAdapter(
                ArrayAdapter(
                    this@ProfileActivity,
                    R.layout.list_item,
                    listOf("Laki-laki", "Perempuan")
                )
            )

            btnBack.setOnClickListener {
                onBackPressed()
            }
        }

    }


}