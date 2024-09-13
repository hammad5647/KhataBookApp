package com.example.khatabook.activities

import android.icu.util.Calendar
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.khatabook.databinding.ActivityCustomerEntryBinding
import com.example.khatabook.helpers.CustomerDatabs.Companion.initDbs
import com.example.khatabook.models.EntityModel

class CustomerEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerEntryBinding
    private lateinit var list: MutableList<EntityModel>
    var intentId = -1
    var productType = 1
    var date:Calendar = Calendar.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerEntryBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        clickInit()
    }

    private fun clickInit() {
        binding.addCustomerBtn.setOnClickListener {
            if (binding.productName.text.toString().isEmpty()) {
                binding.productNameLayout.isErrorEnabled
                binding.productNameLayout.error = "Enter Customer Name"
            } else if (binding.productQnty.text.toString().isEmpty()) {
                binding.productQuantityLayout.isErrorEnabled
                binding.productQuantityLayout.error = "Enter Mobile Number"
            } else if (binding.productRate.text.toString().isEmpty()) {
                binding.productPriceLayout.isErrorEnabled
                binding.productPriceLayout.error = "Enter Email Address"
            } else {
                val name = binding.productName.text.toString()
                val quantity = binding.productQnty.text.toString()
                val rate = binding.productRate.text.toString()

                val customers = EntityModel(cuName = name, cuQuantity = quantity, cuRate = rate)
                val db = initDbs(this)
                db.dao().insertData(customers)
                finish()
            }
        }
        binding.backBtn.setOnClickListener {
            finish()
        }
    }
}