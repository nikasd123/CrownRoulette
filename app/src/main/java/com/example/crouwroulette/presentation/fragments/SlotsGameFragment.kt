package com.example.crouwroulette.presentation.fragments

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.crouwroulette.R
import com.example.crouwroulette.databinding.FragmentSlotsGameBinding

class SlotsGameFragment: Fragment(R.layout.fragment_slots_game) {

    private lateinit var binding: FragmentSlotsGameBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSlotsGameBinding.bind(view)
        navigateToMainMenu()
        fadeInIconsAnimation()
    }

    private fun navigateToMainMenu() {
        binding.fromSlotsGameToMainMenu.setOnClickListener {
            findNavController().navigate(
                R.id.action_slots_game_to_gameChoiceFragment
            )
        }
    }

    private fun fadeInIconsAnimation() {
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
}