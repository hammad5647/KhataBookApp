package com.example.khatabook.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.khatabook.R
import com.example.khatabook.databinding.ActivityAddUserBinding
import com.example.khatabook.helpers.CustomerDatabs.Companion.initDbs
import com.example.khatabook.models.EntityModel

class AddUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddUserBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        clickInit()
    }

    private fun clickInit() {
        binding.addCustomerBtn.setOnClickListener {
            if (binding.customerNameInput.text.toString().isEmpty()) {
                binding.customerNameLayout.isErrorEnabled
                binding.customerNameLayout.error = "Enter Customer Name"
            } else if (binding.mobileInput.text.toString().isEmpty()) {
                binding.mobileLayout.isErrorEnabled
                binding.mobileLayout.error = "Enter Mobile Number"
            } else if (binding.emailInput.text.toString().isEmpty()) {
                binding.emailLayout.isErrorEnabled
                binding.emailLayout.error = "Enter Email Address"
            } else {
                val name = binding.customerNameInput.text.toString()
                val mobile = binding.mobileInput.text.toString()
                val email = binding.emailInput.text.toString()

                val customers = EntityModel( cuName = name, cuMobile = mobile, cuEmail = email)
                val db = initDbs(this)
                db.dao().insertData(customers)
                finish()
            }
        }
    }
}