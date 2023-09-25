package com.example.crouwroulette.presentation.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.crouwroulette.R
import com.example.crouwroulette.databinding.FragmentRouletteGameBinding
import com.example.crouwroulette.presentation.CustomInterpolator
import com.example.crouwroulette.presentation.DecelerateAccelerateInterpolator

class RouletteGameFragment : Fragment(R.layout.fragment_roulette_game) {

    private lateinit var binding: FragmentRouletteGameBinding
    private lateinit var spinAnimation: ObjectAnimator
    private var currentRotation = 0f

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRouletteGameBinding.bind(view)
        initFun()
    }

    private fun initFun() {
        navigateToMainMenu()
        rotateWheelAnimation()
        rotateWheelBySpinButtonAnimation()
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

    private fun initSpinAnimation() {
        val startAngle = currentRotation
        val endAngle = startAngle + 3461f
        val animationDuration = 10000L

        spinAnimation = ObjectAnimator.ofFloat(binding.rouletteSectors, "rotation", startAngle, endAngle)
        spinAnimation.apply {
            duration = animationDuration
            interpolator = CustomInterpolator()
            addUpdateListener { animator ->
                currentRotation = animator.animatedValue as Float
            }
        }
    }

    private fun rotateWheelBySpinButtonAnimation() {
        binding.buttonRouletteSpin.setOnClickListener {
            initSpinAnimation()
            spinAnimation.start()
        }
    }
}