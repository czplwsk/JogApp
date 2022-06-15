package com.example.jogapp

import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.jogapp.R
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import android.widget.TextView

class ImagesAdapter(private val captions: Array<String>, private val imageIds: IntArray) :
    RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {
    private var listener: Listener? = null

    class ViewHolder : RecyclerView.ViewHolder {
        var cardView: CardView? = null

        constructor(v: CardView?) : super(v!!) {
            cardView = v
        }
    }

    interface Listener {
        fun onClick(position: Int)
    }

    fun setListener(listener: Listener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cv = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_captioned_image, parent, false) as CardView
        return ViewHolder(cv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView = holder.cardView
        val imageView = cardView!!.findViewById<View>(R.id.info_image) as ImageView
        val drawable = ContextCompat.getDrawable(cardView.context, imageIds[position])
        imageView.setImageDrawable(drawable)
        imageView.contentDescription = captions[position]
        val textView = cardView.findViewById<View>(R.id.info_text) as TextView
        textView.text = captions[position]
        cardView.setOnClickListener {
            if (listener != null) {
                listener!!.onClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return captions.size
    }
}