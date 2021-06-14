package com.example.mywiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mywiki.R
import com.example.mywiki.holders.CardHolder
import com.example.mywiki.models.WikiPage

class ArticleCardRecyclerAdapter : RecyclerView.Adapter<CardHolder>()
{
    val currentResults: ArrayList<WikiPage> = ArrayList()

    override fun getItemCount(): Int = currentResults.size

    override fun onBindViewHolder(holder: CardHolder, position: Int)
    {
        var page = currentResults[position]

        // update view within holder
        holder?.updateWithPage(page)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder
    {
        var cardItem = LayoutInflater.from(parent.context).inflate(R.layout.article_card_item, parent, false)
        return CardHolder(cardItem)
    }
}