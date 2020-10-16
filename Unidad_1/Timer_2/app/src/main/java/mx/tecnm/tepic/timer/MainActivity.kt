package mx.tecnm.tepic.timer

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val timer = MyCounter(10000, 1000)
        start.setOnClickListener { timer.start() }
        stop.setOnClickListener { timer.cancel() }
    }

    inner class MyCounter(millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {

        override fun onFinish() {
            tv.text = "Timer Completed."
        }

        override fun onTick(millisUntilFinished: Long) {
            tv.textSize = 50f
            tv.text = (millisUntilFinished / 1000).toString() + ""
        }
    }
}
