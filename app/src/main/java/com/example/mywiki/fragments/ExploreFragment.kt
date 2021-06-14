package com.example.mywiki.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mywiki.activities.SearchActivity
import com.example.mywiki.adapters.ArticleCardRecyclerAdapter
import com.example.mywiki.databinding.FragmentExploreBinding
import com.example.mywiki.providers.ArticleDataProvider
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 * Use the [ExploreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExploreFragment : Fragment()
{
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private val articleProvider: ArticleDataProvider = ArticleDataProvider()
    var adapter: ArticleCardRecyclerAdapter = ArticleCardRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View?
    {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)

        binding.searchCardView.setOnClickListener {
            val searchIntent = Intent(context, SearchActivity::class.java)
            context?.startActivity(searchIntent)
        }

        binding.exploreArticleRecycler.layoutManager = LinearLayoutManager(context)
        binding.exploreArticleRecycler.adapter = adapter

        binding.refresher?.setOnRefreshListener {
            getRandomArticles()
        }

        getRandomArticles()

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }

    private fun getRandomArticles()
    {
        binding.refresher?.isRefreshing = true

        try
        {
            articleProvider.getRandom(15) { wikiResult ->
                // do something when we get the articles
                adapter.currentResults.clear()
                adapter.currentResults.addAll(wikiResult.query!!.pages)
                activity?.runOnUiThread {
                    adapter.notifyDataSetChanged()
                    binding.refresher?.isRefreshing = false
                }
            }
        } catch (ex: Exception)
        {
            //show alert
            val builder = AlertDialog.Builder(activity)
            builder.setMessage(ex.message).setTitle("oops!")
            var dialog = builder.create()
            dialog.create()
        }
    }
}