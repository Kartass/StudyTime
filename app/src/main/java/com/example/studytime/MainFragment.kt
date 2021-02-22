package com.example.studytime

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.example.studytime.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        //binding.progressBar.rotation = 270f
        binding.progressBar.progress = 50
        binding.progressBar.setProgressFormatter(ProgressBarFomatter(3030))
        //setProgressBar()
        //binding.progressBar.progress = 50
        //binding.progressBar.setProgressFormatter(ProgressBarFomatter())
        return view
    }
    private fun setProgressBar() {
        val paint = Paint()
        val canvas = Canvas()
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas.drawPaint(paint)
        paint.textSize = 20f
        paint.color = Color.BLACK
        canvas.drawText("0:00", 200f, 200f, paint)
    }
}