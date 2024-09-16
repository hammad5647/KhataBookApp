package com.example.khatabook.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.khatabook.R
import com.example.khatabook.databinding.SpinnerSampleBinding
import com.example.khatabook.models.EntityModel

class SpinnerAdapter(var list: MutableList<EntityModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.count()
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view =
            LayoutInflater.from(parent!!.context).inflate(R.layout.spinner_sample, parent, false)
        val binding = SpinnerSampleBinding.bind(view)
        binding.spinnerTxtName.text = list[position].cuName
        return binding.root

    }
}