package com.example.mywiki.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mywiki.R

class CardHolder(itemview: View) : RecyclerView.ViewHolder(itemview)
{
    private val articleImageView: ImageView = itemview.findViewById(R.id.article_image)
    private val titleTextView = itemView.findViewById<TextView>(R.id.article_title)


}