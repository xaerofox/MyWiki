package com.example.mywiki.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mywiki.R
import com.example.mywiki.adapters.ArticleCardRecyclerAdapter
import com.example.mywiki.adapters.ArticleListItemRecyclerAdapter
import com.example.mywiki.databinding.FragmentExploreBinding
import com.example.mywiki.databinding.FragmentFavoritesBinding

/**
 * A simple [Fragment] subclass.
 * Use the [FavoritesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavoritesFragment : Fragment()
{
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        with(binding.favoritesArticleRecycler)
        {
            layoutManager = LinearLayoutManager(context)
            adapter = ArticleCardRecyclerAdapter()
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}