package com.example.crouwroulette.presentation.fragments

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.crouwroulette.R
import com.example.crouwroulette.databinding.FragmentGameChoiceBinding

class GameChoiceFragment : Fragment(R.layout.fragment_game_choice) {

    private lateinit var binding: FragmentGameChoiceBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentGameChoiceBinding.bind(view)
        initFun()
    }

    private fun initFun() {
        navigateToPrivacyFragment()
        navigateToSlotsGame()
        navigateToRouletteGame()

        animateSlotsGame()
        animateRouletteGame()
    }

    private fun animateSlotsGame() {
        val animations = arrayOf(
            AnimationUtils.loadAnimation(activity, R.anim.fade_in_fast),
            AnimationUtils.loadAnimation(activity, R.anim.fade_in_medium),
            AnimationUtils.loadAnimation(activity, R.anim.fade_in_slow)
        )

        for (i in 0 until binding.slots.childCount) {
            val slotIcon = binding.slots.getChildAt(i)
            val fadeInAnimation = animations[i % animations.size]
            slotIcon.startAnimation(fadeInAnimation)
        }
    }

    private fun animateRouletteGame() {
        val animation = AnimationUtils.loadAnimation(requireContext(), R.anim.infinit_rotate)

        binding.rouletteSectors.startAnimation(animation)
    }

    private fun navigateToPrivacyFragment() {
        binding.buttonPrivacy.setOnClickListener {
            findNavController().navigate(
                R.id.action_gameChoiceFragment_to_privacy
            )
        }
    }

    private fun navigateToSlotsGame() {
        binding.buttonSlotsPlay.setOnClickListener {
            findNavController().navigate(
                R.id.action_gameChoiceFragment_to_slots_game
            )
        }
    }

    private fun navigateToRouletteGame() {
        binding.buttonRoulettePlay.setOnClickListener {
            findNavController().navigate(
                R.id.action_gameChoiceFragment_to_roulette_game
            )
        }
    }
}