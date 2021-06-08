package com.example.mywiki.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.mywiki.databinding.ActivityArticleDetailBinding

class ArticleDetailActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityArticleDetailBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
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

}