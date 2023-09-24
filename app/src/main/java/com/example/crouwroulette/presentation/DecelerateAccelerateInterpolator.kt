package com.example.crouwroulette.presentation

import android.animation.TimeInterpolator
import android.view.animation.Interpolator
import kotlin.math.pow

class DecelerateAccelerateInterpolator: TimeInterpolator, Interpolator {
    override fun getInterpolation(input: Float): Float =
        1 - (1 - input).toDouble().pow(3.0).toFloat()

}