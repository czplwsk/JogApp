package com.example.jogapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class TrailListFragment : ListFragment() {
    private lateinit var listener: Listener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val titles = mutableListOf<String>()
        for (i in Trail.trails.indices){
            titles.add(Trail.trails[i].name)
        }

        val adapter: ArrayAdapter<String> = ArrayAdapter(inflater.context, android.R.layout.simple_list_item_1, titles)
        listAdapter = adapter

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        val intId = id.toInt()
        listener.itemClicked(intId)
    }


    interface Listener {
        fun itemClicked(id: Int)
    }

}