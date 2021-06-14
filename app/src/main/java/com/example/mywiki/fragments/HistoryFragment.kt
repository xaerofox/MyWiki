package com.example.mywiki.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mywiki.R
import com.example.mywiki.adapters.ArticleListItemRecyclerAdapter
import com.example.mywiki.databinding.FragmentFavoritesBinding
import com.example.mywiki.databinding.FragmentHistoryBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryFragment : Fragment()
{
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)

        with(binding.historyArticleRecycler)
        {
            layoutManager = LinearLayoutManager(context)
            adapter = ArticleListItemRecyclerAdapter()
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}