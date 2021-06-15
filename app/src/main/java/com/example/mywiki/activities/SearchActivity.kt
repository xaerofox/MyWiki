package com.example.mywiki.activities

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mywiki.R
import com.example.mywiki.adapters.ArticleListItemRecyclerAdapter
import com.example.mywiki.databinding.ActivitySearchBinding
import com.example.mywiki.models.WikiResult
import com.example.mywiki.providers.ArticleDataProvider

class SearchActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySearchBinding
    private var adapter: ArticleListItemRecyclerAdapter = ArticleListItemRecyclerAdapter()
    private val articleProvider: ArticleDataProvider = ArticleDataProvider()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        binding = ActivitySearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.searchResultsRecycler.layoutManager = LinearLayoutManager(this)
        binding.searchResultsRecycler.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if(item!!.itemId == android.R.id.home)
            finish()

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchItem = menu!!.findItem(R.id.action_search)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = searchItem!!.actionView as SearchView

            searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
            searchView.setIconifiedByDefault(false)
            searchView.requestFocus()

            searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean
                {
                    // do the search and update the elements
                    if (query != null)
                    {
                        articleProvider.search(query, 0, 20) { wikiResult ->
                            adapter.currentResults.clear()
                            wikiResult.query?.pages?.let { adapter.currentResults.addAll(it) }
                            runOnUiThread{ adapter.notifyDataSetChanged() }
                        }
                        println("updated search")
                    }

                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean
                {
                    return false
                }
            })

        return super.onCreateOptionsMenu(menu)
    }
}