package com.example.khatabook

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.khatabook.activities.CustomerEntryActivity
import com.example.khatabook.activities.UserEntryActivity
import com.example.khatabook.adapters.TabAdapter
import com.example.khatabook.databinding.ActivityMainBinding
import com.example.khatabook.fragments.HomeFragment
import com.example.khatabook.fragments.UserFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        initClick()
        val tabAdapter = TabAdapter(this)
        binding.viewPager.adapter = tabAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = "Home"
                1 -> tab.text = "User"
            }

        }.attach()
    }

    private fun initClick() {
        binding.addEntryBtn.setOnClickListener {
            startActivity(Intent(this, CustomerEntryActivity::class.java))
        }
        binding.addUserBtn.setOnClickListener{
            startActivity(Intent(this,UserEntryActivity::class.java))
        }
    }


}