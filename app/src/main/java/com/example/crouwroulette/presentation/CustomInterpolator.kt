package com.example.crouwroulette.presentation

import android.view.animation.Interpolator
import kotlin.math.pow

class CustomInterpolator: Interpolator {
    override fun getInterpolation(input: Float): Float =
        if (input < 0.5f) {
            (2 * input).toDouble().pow(2.0).toFloat()
        } else {
            1 - ((2 * (1 - input)).toDouble().pow(2.0).toFloat())
        }
}