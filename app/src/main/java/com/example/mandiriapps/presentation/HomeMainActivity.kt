package com.example.mandiriapps.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.mandiriapps.R
import com.example.mandiriapps.databinding.ActivityHomeMainBinding
import com.example.mandiriapps.helper.SharedPref
import com.example.mandiriapps.presentation.home.HomeFragment
import com.example.mandiriapps.presentation.message.MessageFragment
import com.example.mandiriapps.utils.ConfirmationDialogUtil
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener
        )

        if (savedInstanceState == null) binding.bottomNavigation.selectedItemId =
            R.id.navigationHome
    }

    private fun logout() {
        val pref = SharedPref(this@HomeMainActivity)
        pref.deleteToken()

        val intent = Intent(this@HomeMainActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    replaceFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationMessage -> {
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationPromo -> {
                    replaceFragment(PromoFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationSettings -> {
                    replaceFragment(SettingsFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationLogout -> {
                    val dialog = ConfirmationDialogUtil(this@HomeMainActivity)
                    dialog.showConfirmationDialog(
                        title = "Apakah yakin keluar?",
                        icon = R.raw.animation_exit,
                        onConfirm = { logout() },
                        onCancel = {
                            Toast.makeText(
                                this@HomeMainActivity,
                                "Dialog cancel",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                    return@OnNavigationItemSelectedListener true
                }
                else -> {
                    return@OnNavigationItemSelectedListener true
                }
            }
        }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}