package com.example.jogapp

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class TrailDetailFragment : Fragment() {
    lateinit var shared: SharedPreferences
    private var trailId: Long = -2
    private val trails = com.example.jogapp.trails

    companion object {
        lateinit var trailName: String
    }

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            trailId = savedInstanceState.getLong("trailId")
        }
        else{
            val stoper = StoperFragment()
            val bundle = Bundle()
            bundle.putInt("id", trailId.toInt())
            stoper.arguments = bundle
            val ft: FragmentTransaction = childFragmentManager.beginTransaction()
            ft.add(R.id.stoper_container, stoper)
            ft.addToBackStack(null)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.commit()

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trail_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        shared = context?.getSharedPreferences("MyPref",MODE_PRIVATE)!!
        shared.edit().putLong("id",trailId).commit()


        val view = view
        if (view != null) {
            trailName = trails[trailId.toInt()].title
            val trail: Trail = trails[trailId.toInt()]

            val title = view.findViewById<View>(R.id.textTitle) as TextView
            title.text = trail.title

            val description = view.findViewById<View>(R.id.textBody) as TextView
            description.text = trail.body
        }
    }

    fun setTrail(id: Long) {
        this.trailId = id
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putLong("trailId", trailId)
    }



}