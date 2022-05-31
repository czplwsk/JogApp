package com.example.jogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var frag : TrailDetailFragment = supportFragmentManager.findFragmentById(R.id.detail_frag) as TrailDetailFragment

        val extras = intent.extras
        if(extras!=null) {
            frag.setTrail(extras.get("ID") as Long)
        }
    }
}