package com.vit.countdowntimerwithprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private val time = 30000
    private val oneSecond = 1000


    private val countDownTimer = object:CountDownTimer(time.toLong(), oneSecond.toLong()){
        /**
         * Callback fired when the time is up.
         */
        override fun onFinish() {
            progressBar.progress = time
        }

        /**
         * Callback fired on regular interval.
         * @param millisUntilFinished The amount of time until finished.
         */
        override fun onTick(millisUntilFinished: Long) {
            progressBar.progress = (millisUntilFinished / oneSecond.toDouble()).roundToInt()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.max = time/oneSecond
        progressBar.progress = time/oneSecond
        countDownTimer.start()
    }


    override fun onUserInteraction() {
        super.onUserInteraction()
        countDownTimer.start()
    }
}
