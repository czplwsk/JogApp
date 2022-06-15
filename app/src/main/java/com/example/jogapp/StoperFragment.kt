package com.example.jogapp


import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*


class StoperFragment : Fragment(), View.OnClickListener {
    lateinit var shared: SharedPreferences
    private var seconds = 0
    var idTrail: Int = 0
    private var running = false
    private var wasRunning = false
    lateinit var time: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        shared = context?.getSharedPreferences("MyPref",MODE_PRIVATE)!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, SavedInstanceState: Bundle?): View? {
        val layout: View = inflater.inflate(R.layout.fragment_stoper, container, false)
        runStoper(layout)
        val startButton: Button = layout.findViewById<View>(R.id.start_button) as Button
        startButton.setOnClickListener(this)
        val stopButton: Button = layout.findViewById<View>(R.id.stop_button) as Button
        stopButton.setOnClickListener(this)
        val resetButton: Button = layout.findViewById<View>(R.id.reset_button) as Button
        resetButton.setOnClickListener(this)
        val saveButton: Button = layout.findViewById<View>(R.id.save_button) as Button
        saveButton.setOnClickListener(this)
        return layout
    }

    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) {
            running = true
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putInt("seconds", seconds)
        savedInstanceState.putBoolean("running", running)
        savedInstanceState.putBoolean("wasRunning", wasRunning)
    }


    fun onClickStart() {
        running = true
    }

    fun onClickStop() {
        running = false
    }

    fun onClickReset() {
        running = false
        seconds = 0
    }

    @SuppressLint("SetTextI18n")
    fun onClickSave(){

        idTrail = (shared.all["id"] as Int)
        val trail = trails[idTrail]
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        val naj = trail.bestScore
        val ost = trail.lastScore
        val najView = view?.findViewById<View>(R.id.naj_wynik) as TextView
        val ostView = view?.findViewById<View>(R.id.ost_wynik) as TextView
        najView.text = "Rekord trasy: ${naj} sekund"
        ostView.text = "Ostatni wynik na trasie: ${ost} sekund z dnia ${currentDate}"

        if(seconds > naj){
            trail.bestScore = seconds
            najView.text = "Rekord trasy: ${seconds} sekund z dnia ${currentDate}"
        }

        trail.lastScore = seconds
        ostView.text = "Ostatni wynik na trasie: ${seconds} z dnia ${currentDate}"


    }


    private fun runStoper(view: View) {
        val timeView = view.findViewById<View>(R.id.time_view) as TextView
        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = seconds % 3600 / 60
                val secs = seconds % 60
                time = String.format("%d:%02d:%02d", hours, minutes, secs)
                timeView.text = time
                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.start_button -> onClickStart()
            R.id.stop_button -> onClickStop()
            R.id.reset_button -> onClickReset()
            R.id.save_button -> onClickSave()
        }
    }




}