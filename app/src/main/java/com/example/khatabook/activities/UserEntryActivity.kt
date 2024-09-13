package com.example.khatabook.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.khatabook.databinding.ActivityUserEntryBinding

class UserEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserEntryBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserEntryBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        onClicks()

    }

    private fun onClicks() {
        binding.productPriceLayout.setOnClickListener {
            val quantity = binding.productQtyInput.text.toString()
            val price = binding.productQtyInput.text.toString()
            val total = quantity.toInt() * price.toInt()

            binding.totalSalesAmount.setText("$total")
            binding.backBtn.setOnClickListener {
                finish()
            }
        }
        binding.backBtn.setOnClickListener{
            finish()
        }
    }
}