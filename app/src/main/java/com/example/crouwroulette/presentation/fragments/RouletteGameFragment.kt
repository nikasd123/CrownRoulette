package com.example.crouwroulette.presentation.fragments

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.crouwroulette.R
import com.example.crouwroulette.databinding.FragmentRouletteGameBinding
import com.example.crouwroulette.presentation.DecelerateAccelerateInterpolator

class RouletteGameFragment : Fragment(R.layout.fragment_roulette_game) {

    private lateinit var binding: FragmentRouletteGameBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRouletteGameBinding.bind(view)
        navigateToMainMenu()
        rotateWheelAnimation()
    }

    private fun navigateToMainMenu() {
        binding.fromRouletteGameToMainMenu.setOnClickListener {
            findNavController().navigate(
                R.id.action_roulette_game_to_gameChoiceFragment
            )
        }
    }

    private fun rotateWheelAnimation() {
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate)

        animation.interpolator = DecelerateAccelerateInterpolator()

        binding.rouletteSectors.startAnimation(animation)
    }
}