package com.example.jogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){



    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                FrontFragment()
            }
            1 -> {
                Tab1Fragment()
            }
            2 -> {
                Tab1Fragment()
            }

            else -> {Fragment()}
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0-> {"Karta główna"}
            1-> {"Trudność"}
            2-> {"Dlugość"}
            else -> {""}
        }
    }
}
