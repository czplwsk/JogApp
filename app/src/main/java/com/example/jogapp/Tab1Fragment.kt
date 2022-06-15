package com.example.jogapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jogapp.CaptionedImagesAdapter.Listener

class Tab1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tab1Recycler =
            inflater.inflate(R.layout.fragment_tab1, container, false) as RecyclerView
        val trailNames = arrayOfNulls<String>(Trail.trails.size)
        for (i in trailNames.indices) {
            trailNames[i] = Trail.trails[i].name
        }
        val trailImages = IntArray(Trail.trails.size)
        for (i in trailImages.indices) {
            trailImages[i] = Trail.trails[i].imageResourceId
        }
        val adapter = CaptionedImagesAdapter(trailNames, trailImages)
        tab1Recycler.adapter = adapter
        val layoutManager = GridLayoutManager(activity, 2)
        tab1Recycler.layoutManager = layoutManager

        adapter.setListener(object : Listener {
            override fun onClick(position: Int) {
                val fragmentContainer =  view?.findViewById<View>(R.id.fragment_container)
                if(fragmentContainer != null){

                    val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
                    val fragment = TrailDetailFragment()
                    val intId = id.toInt()
                    fragment.setTrail(intId)
                    transaction.replace(R.id.fragment_container, fragment)
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    transaction.addToBackStack(null)
                    transaction.commit()
                } else {
                    val intent = Intent(activity, DetailActivity::class.java)
                    intent.putExtra("ID", position)
                    startActivity(intent)
                }


//                val intent = Intent(activity, DetailActivity::class.java)
//                intent.putExtra("ID", position)
//                activity?.startActivity(intent)
            }
        })

        return tab1Recycler
    }
}