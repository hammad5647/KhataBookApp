package com.example.khatabook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import com.example.khatabook.R
import com.example.khatabook.adapters.UserAdapter
import com.example.khatabook.databinding.FragmentUserBinding

class UserFragment : Fragment() {
    lateinit var binding: FragmentUserBinding
    lateinit var userPermission: ActivityResultLauncher<Array<String>>
    lateinit var adapter: UserAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentUserBinding.inflate(inflater, container, false)


        return binding.root
    }
}