package com.example.mandiriapps

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mandiriapps.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val password = "12345"

        binding.apply {
            btnLogin.setOnClickListener {
                tilPassword.editText?.let { edt ->
                    val inPassword = edt.text.toString()

                    if (inPassword.isEmpty()) {
                        tilPassword.showError("Masukkan Password")
                    } else if (inPassword == password) {
                        tilPassword.error = null
                        Toast.makeText(this@MainActivity, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@MainActivity, HomeActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        tilPassword.showError("Password salah")
                    }
                }
            }
            btnRegister.setOnClickListener {
                startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
            }
        }

    }

    fun TextInputLayout.showError(message: String) {
        errorIconDrawable = null
        error = message
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}