package com.example.mandiriapps.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mandiriapps.R
import com.example.mandiriapps.adapter.SettingsAdapter
import com.example.mandiriapps.databinding.FragmentSettingsBinding
import com.example.mandiriapps.model.CompartmentSettingsModel
import com.example.mandiriapps.model.SettingsModel

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAccountRecyclerView()
        setupFeatureRecyclerView()
        setupSecurityRecyclerView()
    }

    private fun setupAccountRecyclerView() {
        binding.compAccount.apply {
            divider.visibility = View.GONE
            tvCompartmentTitle.text = dummyAccountData.title
            val accountAdapter = SettingsAdapter(dummyAccountData.settings)
            rvSettings.apply {
                adapter = accountAdapter
                layoutManager = LinearLayoutManager(activity)
            }
        }
    }

    private fun setupFeatureRecyclerView() {
        binding.compFeature.apply {
            tvCompartmentTitle.text = dummyFeatureData.title
            val featureAdapter = SettingsAdapter(dummyFeatureData.settings)
            rvSettings.apply {
                adapter = featureAdapter
                layoutManager = LinearLayoutManager(activity)
            }
        }
    }

    private fun setupSecurityRecyclerView() {
        binding.compSecurity.apply {
            tvCompartmentTitle.text = dummySecurityData.title
            val securityAdapter = SettingsAdapter(dummySecurityData.settings)
            rvSettings.apply {
                adapter = securityAdapter
                layoutManager = LinearLayoutManager(activity)
            }
        }
    }

    private val dummyAccountData = CompartmentSettingsModel(
        title = "Akun",
        settings = listOf(
            SettingsModel(
                icon = R.drawable.ic_baseline_add_24,
                title = "Tambah"
            ),
            SettingsModel(
                icon = R.drawable.ic_baseline_mail_24,
                title = "Email"
            ),
            SettingsModel(
                icon = R.drawable.ic_baseline_person_24,
                title = "Data Diri"
            ),
        )
    )

    private val dummyFeatureData = CompartmentSettingsModel(
        title = "Fitur",
        settings = listOf(
            SettingsModel(
                icon = R.drawable.ic_baseline_mail_24,
                title = "Ubah Email"
            ),
            SettingsModel(
                icon = R.drawable.ic_baseline_credit_card_24,
                title = "Kartu Kredit"
            ),
            SettingsModel(
                icon = R.drawable.ic_baseline_person_24,
                title = "Data Diri"
            ),
            SettingsModel(
                icon = R.drawable.ic_baseline_arrow_back_24,
                title = "Kembali"
            ),
            SettingsModel(
                icon = R.drawable.ic_baseline_add_24,
                title = "Tambah Fitur"
            ),
        )
    )

    private val dummySecurityData = CompartmentSettingsModel(
        title = "Keamanan",
        settings = listOf(
            SettingsModel(
                icon = R.drawable.ic_baseline_mail_24,
                title = "Ubah Email"
            ),
            SettingsModel(
                icon = R.drawable.ic_baseline_person_24,
                title = "Data Diri"
            ),
            SettingsModel(
                icon = R.drawable.ic_baseline_add_24,
                title = "Tambah Kemanan"
            ),
        )
    )
}