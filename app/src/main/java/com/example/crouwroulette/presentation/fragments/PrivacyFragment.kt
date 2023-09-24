package com.example.crouwroulette.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.crouwroulette.R
import com.example.crouwroulette.databinding.FragmentPrivacyBinding

class PrivacyFragment : Fragment(R.layout.fragment_privacy) {

    private lateinit var binding: FragmentPrivacyBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPrivacyBinding.bind(view)
        navigateToMainMenu()
    }

    private fun navigateToMainMenu() {
        binding.fromPrivacyToMainMenu.setOnClickListener {
            findNavController().navigate(
                R.id.action_privacy_to_gameChoiceFragment
            )
        }
    }
}