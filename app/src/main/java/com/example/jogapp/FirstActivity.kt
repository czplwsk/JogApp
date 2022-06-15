package com.example.jogapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FirstActivity : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_first)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val thread = Thread{ //kod ze stronki====================================
            run{
                Thread.sleep(3000)
            }
            runOnUiThread{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                this.onStop()
            }
        }
        thread.start()
    }
}