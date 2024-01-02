package com.example.mandiriapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mandiriapps.databinding.ActivityMainBinding
import com.example.mandiriapps.helper.SharedPref
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var pref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val password = "12345"

        pref = SharedPref(this)

        if (checkAvailableToken())
            navigateToHome()

        binding.apply {
            btnLogin.setOnClickListener {
                tilPassword.editText?.let { edt ->
                    val inPassword = edt.text.toString()

                    if (inPassword.isEmpty()) {
                        tilPassword.showError("Masukkan Password")
                    } else if (inPassword == password) {
                        tilPassword.error = null
                        Toast.makeText(this@MainActivity, "Berhasil Masuk", Toast.LENGTH_SHORT).show()

                        val dummyToken = UUID.randomUUID().toString()
                        pref.saveToken(dummyToken)

                        navigateToHome()

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

    private fun navigateToHome() {
        val intent = Intent(this@MainActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun checkAvailableToken(): Boolean = pref.getToken().isNotEmpty()

    private fun TextInputLayout.showError(message: String) {
        errorIconDrawable = null
        error = message
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}