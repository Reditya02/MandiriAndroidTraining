package com.example.mandiriapps.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.mandiriapps.databinding.ActivityMainBinding
import com.example.mandiriapps.helper.SharedPref
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var pref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (checkAvailableToken())
            navigateToHome()

        binding.apply {
            btnLogin.setOnClickListener(this@MainActivity)
            btnRegister.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(v: View?) {
        binding.apply {
            when (v) {
                btnLogin -> {
                    val password = "12345"
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
                btnRegister -> {
                    startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
                }
            }
        }

    }

    private fun navigateToHome() {
        val intent = Intent(this@MainActivity, HomeMainActivity::class.java)
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