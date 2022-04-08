package com.invoice.contratista.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.invoice.contratista.R


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val timer: Thread = object : Thread() {
            override fun run() {
                try { sleep(1500) } finally {
                    startActivity(Intent(this@SplashScreen, StartActivity::class.java))
                    finish()
                }
            }
        }
        timer.start()
    }
}