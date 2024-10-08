package com.example.khatabook.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.khatabook.adapters.CustomerAdapter
import com.example.khatabook.databinding.FragmentHomeBinding
import com.example.khatabook.helpers.CustomerDatabs.Companion.initDbs
import com.example.khatabook.models.EntityModel

class HomeFragment : Fragment() {
    private var customers = mutableListOf<EntityModel>()
    private var adapter: CustomerAdapter? = null
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        adapter = CustomerAdapter(customers)
        binding.homeViewRecycler.adapter = adapter

        return binding.root
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        val db = initDbs(requireContext())

        customers = db.dao().customerReadData()
        adapter!!.dataChange(customers)
    }
}