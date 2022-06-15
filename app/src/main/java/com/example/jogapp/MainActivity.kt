package com.example.jogapp

//import android.support.v4.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() ,TrailListFragment.Listener {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val fragmentContainer = findViewById<View>(R.id.fragment_container)
        if(fragmentContainer == null) {

            val pagerAdapter = SectionsPagerAdapter((supportFragmentManager))
            viewPager = findViewById(R.id.pager)
            viewPager.adapter = pagerAdapter

            val tabs = findViewById<TabLayout>(R.id.tabs)
            tabs?.setupWithViewPager(viewPager)
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


    override fun itemClicked(id: Int) {
        val fragmentContainer = findViewById<View>(R.id.fragment_container)
        if(fragmentContainer != null){

            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            val fragment = TrailDetailFragment()
            val intId = id.toInt()
            fragment.setTrail(intId)
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