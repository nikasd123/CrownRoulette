package com.example.crouwroulette.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.crouwroulette.R
import com.example.crouwroulette.databinding.FragmentSlotsGameBinding

class SlotsGameFragment : Fragment(R.layout.fragment_slots_game) {

    private lateinit var binding: FragmentSlotsGameBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSlotsGameBinding.bind(view)
        navigateToMainMenu()
    }

    private fun navigateToMainMenu() {
        binding.fromSlotsGameToMainMenu.setOnClickListener {
            findNavController().navigate(
                R.id.action_slots_game_to_gameChoiceFragment
            )
        }
    }
}