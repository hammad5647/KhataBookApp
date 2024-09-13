package com.example.khatabook.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.khatabook.fragments.HomeFragment
import com.example.khatabook.fragments.UserFragment

class TabAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> UserFragment()
            else -> HomeFragment()
        }
    }
}