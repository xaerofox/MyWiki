package com.example.mywiki.holders

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mywiki.R
import com.example.mywiki.activities.ArticleDetailActivity
import com.example.mywiki.models.WikiPage
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    private val articleImageView: ImageView = itemView.findViewById(R.id.result_icon)
    private val titleTextView = itemView.findViewById<TextView>(R.id.result_title)
    private var currentPage: WikiPage? = null

    init
    {
        itemView.setOnClickListener { view: View? ->
            var detailPageIntent = Intent(itemView.context, ArticleDetailActivity::class.java)
            var pageJson = Gson().toJson(currentPage)
            detailPageIntent.putExtra("page", pageJson)
            itemView.context.startActivity(detailPageIntent)
        }
    }


    fun updateWithPage(page: WikiPage)
    {
        if(page.thumbnail != null)
            Picasso.with(itemView.context).load(page.thumbnail!!.source).into(articleImageView)

        titleTextView.text = page.title

        currentPage = page
    }


}