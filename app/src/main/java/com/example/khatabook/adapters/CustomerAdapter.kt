package com.example.khatabook.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.khatabook.R
import com.example.khatabook.databinding.CustomerSampleBinding
import com.example.khatabook.models.EntityModel

class CustomerAdapter (private var customers: MutableList<EntityModel>):
    RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {
    class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var binding = CustomerSampleBinding.bind(itemView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.customer_sample,parent,false)
        return CustomerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return customers.size
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        holder.binding.sampleViewCustomerName.text = customers[position].cuName

    }
    @SuppressLint("NotifyDataSetChanged")
    fun dataChange(list : MutableList<EntityModel>){
        customers = list
        notifyDataSetChanged()
    }
}