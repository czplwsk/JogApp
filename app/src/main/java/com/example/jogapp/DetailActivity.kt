package com.example.jogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        var frag : TrailDetailFragment = supportFragmentManager.findFragmentById(R.id.detail_frag) as TrailDetailFragment

        val extras = intent.extras
        if(extras!=null) {
            frag.setTrail(extras.get("ID") as Long)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.settings -> {
                Toast.makeText(this, "Brak ustawień", Toast.LENGTH_SHORT).show()
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }
}