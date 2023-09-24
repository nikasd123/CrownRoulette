package com.example.crouwroulette.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.crouwroulette.R
import com.example.crouwroulette.databinding.FragmentGameChoiceBinding

class GameChoiceFragment : Fragment(R.layout.fragment_game_choice) {

    private lateinit var binding: FragmentGameChoiceBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentGameChoiceBinding.bind(view)
        initNavigateFun()
    }

    private fun initNavigateFun(){
        navigateToPrivacyFragment()
        navigateToSlotsGame()
        navigateToRouletteGame()
    }

    private fun navigateToPrivacyFragment() {
        binding.buttonPrivacy.setOnClickListener {
            findNavController().navigate(
                R.id.action_gameChoiceFragment_to_privacy
            )
        }
    }

    private fun navigateToSlotsGame() {
        binding.buttonPrivacy.setOnClickListener {
            findNavController().navigate(
                R.id.action_gameChoiceFragment_to_slots_game
            )
        }
    }

    private fun navigateToRouletteGame() {
        binding.buttonPrivacy.setOnClickListener {
            findNavController().navigate(
                R.id.action_gameChoiceFragment_to_roulette_game
            )
        }
    }
}