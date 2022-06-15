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
    private lateinit var shared: SharedPreferences
    private var trailId: Int = -2
    private val trails = Trail.trails

    companion object {
        lateinit var trailName: String
    }

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            trailId = savedInstanceState.getInt("trailId")
        }
        else{
            val stoper = StoperFragment()
            val bundle = Bundle()
            bundle.putInt("id", trailId)
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
        shared.edit().putInt("id",trailId).apply()


        val view = view
        if (view != null) {
            trailName = trails[trailId].name
            val trailClass: Trail = trails[trailId]

            val title = view.findViewById<View>(R.id.textTitle) as TextView
            title.text = trailClass.name

            val description = view.findViewById<View>(R.id.textBody) as TextView
            description.text = trailClass.description
        }
    }

    fun setTrail(id: Int) {
        this.trailId = id
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("trailId", trailId)
    }



}