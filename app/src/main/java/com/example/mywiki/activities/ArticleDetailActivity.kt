package com.example.mywiki.activities

import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.mywiki.databinding.ActivityArticleDetailBinding
import com.example.mywiki.models.WikiPage
import com.google.gson.Gson

class ArticleDetailActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityArticleDetailBinding
    private var currentPage: WikiPage? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // get the page from the entries
        val wikiPageJson = intent.getStringExtra("page")
        currentPage = Gson().fromJson<WikiPage>(wikiPageJson, WikiPage::class.java)
        binding.articleDetailWebview?.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean
            {
                return super.shouldOverrideUrlLoading(view, request)
            }
        }

        currentPage!!.fullurl?.let { binding.articleDetailWebview.loadUrl(it) }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if(item!!.itemId == android.R.id.home)
            finish()

        return true
    }

}