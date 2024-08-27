package com.example.khatabook

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.khatabook.activities.AddUserActivity
import com.example.khatabook.databinding.ActivityMainBinding
import com.example.khatabook.fragments.HomeFragment
import com.example.khatabook.fragments.UserFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        loadFragment(HomeFragment())
        initClick()
    }

    private fun initClick() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.Home -> loadFragment(HomeFragment())
                R.id.User -> loadFragment(UserFragment())
                else -> loadFragment(HomeFragment())
            }
            false
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.commit()

    }
}