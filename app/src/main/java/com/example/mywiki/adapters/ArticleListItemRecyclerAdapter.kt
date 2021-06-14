package com.example.mywiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mywiki.R
import com.example.mywiki.holders.CardHolder

class ArticleCardRecyclerAdapter : RecyclerView.Adapter<CardHolder>()
{
    override fun getItemCount(): Int = 15

    override fun onBindViewHolder(holder: CardHolder, position: Int)
    {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder
    {
        var cardItem = LayoutInflater.from(parent.context).inflate(R.layout.article_card_item, parent, false)
        return CardHolder(cardItem)
    }
}