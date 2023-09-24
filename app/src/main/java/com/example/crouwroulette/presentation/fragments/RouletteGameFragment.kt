package com.example.crouwroulette.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.crouwroulette.R
import com.example.crouwroulette.databinding.FragmentRouletteGameBinding

class RouletteGameFragment : Fragment(R.layout.fragment_roulette_game) {

    private lateinit var binding: FragmentRouletteGameBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRouletteGameBinding.bind(view)
        navigateToMainMenu()
    }

    private fun navigateToMainMenu() {
        binding.fromRouletteGameToMainMenu.setOnClickListener {
            findNavController().navigate(
                R.id.action_roulette_game_to_gameChoiceFragment
            )
        }
    }
}