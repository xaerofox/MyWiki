package com.example.mywiki.activities.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mywiki.R
import com.example.mywiki.activities.SearchActivity
import com.example.mywiki.databinding.FragmentExploreBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ExploreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExploreFragment : Fragment()
{
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root

        binding.searchCardView.setOnClickListener {
            val searchIntent = Intent(context, SearchActivity::class.java)
            context?.startActivity(searchIntent)
        }

    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }
}