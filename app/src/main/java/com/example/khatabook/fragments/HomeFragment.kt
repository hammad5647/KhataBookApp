package com.example.khatabook.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khatabook.R
import com.example.khatabook.activities.AddUserActivity
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

        clickInit()
        return binding.root
    }

    private fun clickInit() {
        binding.addUserBtn.setOnClickListener {
            val intent = Intent(context, AddUserActivity::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        val db = initDbs(requireContext())

        customers = db.dao().readData()
        adapter!!.dataChange(customers)
    }
}