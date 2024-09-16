package com.example.khatabook.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.khatabook.databinding.ActivityUserEntryBinding
import com.example.khatabook.helpers.CustomerDatabs.Companion.db
import com.example.khatabook.helpers.CustomerDatabs.Companion.initDbs
import com.example.khatabook.models.EntityModel

class UserEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserEntryBinding
    private lateinit var list: MutableList<EntityModel>
    private var toUpdateId: Int = -1

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserEntryBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        onClicks()

    }

    private fun onClicks() {
        binding.addUserBtn.setOnClickListener {
            setData()
        }
    }

    private fun setData() {
        val customerName = binding.customerNameInput.text.toString()
        val customerNumber = binding.mobileInput.toString()
        val customerHouseNo = binding.homeNumberInput.text.toString()
        val customerArea = binding.areaInput.text.toString()
        val customerState = binding.stateInput.text.toString()
        val customerCity = binding.cityInput.text.toString()
        val customerPin = binding.pinInput.text.toString()

        if (customerName.isEmpty()) {
            binding.customerNameLayout.setEnabled(true)
            binding.customerNameLayout.setError("Enter Name")
        } else if (customerNumber.isEmpty()) {
            binding.customerMobileLayout.setEnabled(true)
            binding.customerMobileLayout.setError("Enter Mobile Number")
        } else if (customerHouseNo.isEmpty()) {
            binding.homeNumberLayout.setEnabled(true)
            binding.homeNumberLayout.setError("Enter House/Flat Number")
        } else if (customerArea.isEmpty()) {
            binding.areaLayout.setEnabled(true)
            binding.areaLayout.setError("Enter Area")
        } else if (customerState.isEmpty()) {
            binding.stateLayout.setEnabled(true)
            binding.stateLayout.setError("Enter State")
        } else if (customerCity.isEmpty()) {
            binding.cityLayout.setEnabled(true)
            binding.cityLayout.setError("Enter City")
        } else if (customerPin.isEmpty()) {
            binding.pinLayout.setEnabled(true)
            binding.pinLayout.setError("Enter Pin Code")
        } else {
            val customerEntity =
                EntityModel(
                    cuName = customerName,
                    cuMobile = customerNumber,
                    cuPincode = customerPin,
                    cuArea = customerArea,
                    cuCity = customerCity,
                    cuFlat = customerHouseNo,
                    cuState = customerState
                )
            initDbs(this)
            if (toUpdateId == -1) {
                db!!.dao().customerInsertData(customerEntity)
            } else {
                customerEntity.cuId = toUpdateId
                db!!.dao().customerUpdateData(customerEntity)

            }
            finish()
        }
        fun getData() {

        }
    }
}