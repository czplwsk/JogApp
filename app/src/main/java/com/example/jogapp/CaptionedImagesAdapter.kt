package com.example.jogapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CaptionedImagesAdapter(private val captions: Array<String?>, private val imageIds: IntArray) :
    RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {

    private lateinit var listener: Listener

    interface Listener {
        fun onClick(position: Int)
    }

    @JvmName("setListener1")
    fun setListener(listener: Listener?){
        if (listener != null) {
            this.listener = listener
        }
    }


    class ViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(
        cardView
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cv = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_captioned_image, parent, false) as CardView
        return ViewHolder(cv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView = holder.cardView
        val imageView = cardView.findViewById<View>(R.id.info_image) as ImageView
        val drawable = ContextCompat.getDrawable(cardView.context, imageIds[position])
        imageView.setImageDrawable(drawable)
        imageView.contentDescription = captions[position]
        val textView = cardView.findViewById<View>(R.id.info_text) as TextView
        textView.text = captions[position]

        cardView.setOnClickListener {
            listener.onClick(position)
        }


    }

    override fun getItemCount(): Int {
        return captions.size
    }
}