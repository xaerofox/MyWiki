package com.example.mywiki.activities

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import com.example.mywiki.R
import com.example.mywiki.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        binding = ActivitySearchBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
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

        with(searchView)
        {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            setIconifiedByDefault(false)
            requestFocus()

            setOnQueryTextListener(object: SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean
                {
                    // do the search and update the elements
                    println("updated search")

                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean
                {
                    return false
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }
}