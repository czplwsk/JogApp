package com.example.jogapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TrailDetailFragment : Fragment() {
    var trailId: Long = -1
    lateinit var trail: Trail


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        if(view != null){
            var title = view?.findViewById<TextView>(R.id.textTitle)
            var body = view?.findViewById<TextView>(R.id.textBody)
            trail = trails[trailId.toInt()]
            title?.text = trail.title
            body?.text = trail.body

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trail_detail, container, false)
    }

    fun setTrail(id: Long){
        this.trailId = id
    }

}