package com.example.mywiki.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mywiki.R
import com.example.mywiki.holders.CardHolder
import com.example.mywiki.holders.ListItemHolder
import com.example.mywiki.models.WikiPage
import com.example.mywiki.models.WikiResult

class ArticleListItemRecyclerAdapter : RecyclerView.Adapter<ListItemHolder>()
{
    val currentResults: ArrayList<WikiPage> = ArrayList()

    override fun getItemCount(): Int = currentResults.size

    override fun onBindViewHolder(holder: ListItemHolder, position: Int)
    {
        var page = currentResults[position]
        holder?.updateWithPage(page)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder
    {
        var listItem = LayoutInflater.from(parent.context).inflate(R.layout.article_list_item, parent, false)
        return ListItemHolder(listItem)
    }
}