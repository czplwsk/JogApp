package com.example.jogapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
//import android.support.v4.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() , TrailListFragment.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
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


    override fun itemClicked(id: Long) {
        val fragmentContainer = findViewById<View>(R.id.fragment_container)
        if(fragmentContainer != null){

            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            val fragment: TrailDetailFragment = TrailDetailFragment()
            fragment.setTrail(id)
            transaction.replace(R.id.fragment_container, fragment)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            transaction.addToBackStack(null)
            transaction.commit()
        } else {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("ID", id)
            startActivity(intent)
        }
    }
}