package com.example.studytime

import com.dinuscxj.progressbar.CircleProgressBar
import java.lang.String

class ProgressBarFomatter(val sec : Int) : CircleProgressBar.ProgressFormatter {
    private val DEFAULT_PATTERN = "%d%d:%d%d:%d%d"
    override fun format(p0: Int, p1: Int): CharSequence {
        val hour = sec / 3600
        val min = (sec % 3600) / 60
        val second = sec % 60


        return String.format(
            DEFAULT_PATTERN,
            //(p0.toFloat() / p1.toFloat() * 100).toInt()
            hour / 10,
            hour % 10,
            min / 10,
            min % 10,
            second / 10,
            second % 10
        )
    }
}