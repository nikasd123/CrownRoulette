package com.example.crouwroulette.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import android.widget.GridLayout
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.crouwroulette.R
import com.example.crouwroulette.databinding.FragmentSlotsGameBinding
import java.util.Random

class SlotsGameFragment<Button> : Fragment(R.layout.fragment_slots_game) {

    private lateinit var binding: FragmentSlotsGameBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSlotsGameBinding.bind(view)
        navigateToMainMenu()
        animateSlots()
    }

    private fun navigateToMainMenu() {
        binding.fromSlotsGameToMainMenu.setOnClickListener {
            findNavController().navigate(
                R.id.action_slots_game_to_gameChoiceFragment
            )
        }
    }

    private fun animateSlots() {
        // Получите ссылки на ImageView в GridLayout
        val gridLayout: GridLayout = binding.root.findViewById(R.id.slots)
        val columnCount = gridLayout.columnCount
        val rowCount = gridLayout.rowCount

        val scrollAnimation = AnimationUtils.loadAnimation(context, R.anim.scroll_anim)

//        scrollAnimation.setAnimationListener(object : Animation.AnimationListener {
//            override fun onAnimationStart(animation: Animation?) {
//                // Анимация началась
//            }
//
//            override fun onAnimationEnd(animation: Animation?) {
//                updateSlotIcons()
//            }
//
//            override fun onAnimationRepeat(animation: Animation?) {
//                // Анимация повторяется
//            }
//        })

        for (column in 0 until columnCount) {
            val delay = column * 100 // Задержка в миллисекундах для каждой колонки
            val columnAnimation = AlphaAnimation(0.0f, 1.0f)
            columnAnimation.duration = 1000 // Длительность анимации в миллисекундах
            columnAnimation.startOffset = delay.toLong() // Установка задержки
            gridLayout.getChildAt(column).startAnimation(columnAnimation)
        }
        binding.buttonSlotsSpin.setOnClickListener {
            gridLayout.getChildAt(columnCount).startAnimation(scrollAnimation)
        }
    }

    fun updateSlotIcons() {
        val slotIcons = listOf(
            R.drawable.img_pokies7,
            R.drawable.img_pokies_10,
            R.drawable.img_pokies_a,
            R.drawable.img_pokies_diamond,
            R.drawable.img_pokies_heart,
            R.drawable.img_pokies_j,
            R.drawable.img_pokies_q,
            R.drawable.img_pokies_k
        )

        val random = Random()

        // Обойти все элементы GridLayout и обновить их значки
        for (row in 0 until binding.slots.rowCount) {
            for (column in 0 until binding.slots.columnCount) {
                val randomIcon = slotIcons[random.nextInt(slotIcons.size)]
                val imageView = ImageView(context)
                imageView.setImageResource(randomIcon)

                // Установите новый значок в соответствующий элемент GridLayout
                val params = GridLayout.LayoutParams()
                params.rowSpec = GridLayout.spec(row)
                params.columnSpec = GridLayout.spec(column)
                imageView.layoutParams = params

                binding.slots.addView(imageView, row * binding.slots.columnCount + column)
            }
        }
    }
}