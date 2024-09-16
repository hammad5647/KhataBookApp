package com.example.khatabook.activities

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.SpinnerAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.khatabook.databinding.ActivityCustomerEntryBinding
import com.example.khatabook.helpers.CustomerDatabs.Companion.initDbs
import com.example.khatabook.models.EntityModel
import com.example.khatabook.models.EntryEntity
import java.text.SimpleDateFormat
import java.util.Locale

class CustomerEntryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerEntryBinding
    private var list = mutableListOf<EntityModel>()
    private var customersTodaysDate = ""
    private var entryType: Int = 1
    private var dateFormat: String = ""
    private var calendar: Calendar = Calendar.getInstance()
    private lateinit var spinnerAdapter: SpinnerAdapter
    private var entryCurrentDate = ""
    private var totalAmount: String = ""
    private var productType: Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerEntryBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        clickInit()
    }

    @SuppressLint("SimpleDateFormat")
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

                val customerEntryName = list[binding.spinner.selectedItemPosition]

                val customers = EntryEntity(
                    customerIDEntry = customerEntryName.cuId,
                    productNameEntry = name,
                    productQuantityEntry = quantity,
                    productRateEntry = rate,
                    productDateEntry = entryCurrentDate,
                    productAmountEntry = totalAmount,
                    productTypeEntry = productType,
                    productCollectEntry = dateFormat
                )
                val db = initDbs(this)
                db.dao().entryInsertData(customers)
                finish()
            }
        }
        paymentType()
        binding.reminderDateTxt.setOnClickListener {
            reminderDatePicker()
        }
        binding.dateSelectTxt.setOnClickListener {
            currentDatePicker()
        }
        binding.backBtn.setOnClickListener {
            finish()
        }

        val dateSelect = SimpleDateFormat("dd/MM/yyyy")
        customersTodaysDate = dateSelect.format(System.currentTimeMillis())
        binding.dateSelectTxt.text = customersTodaysDate

        if (binding.radioCredit.isChecked) {
            binding.paymentReminderView.visibility = View.VISIBLE
        }

    }

    private fun getSetData() {

    }


    private fun reminderDatePicker() {
        val dateDialog = DatePickerDialog(
            this, { _, year, months, day ->
                val pickedDate = Calendar.getInstance()
                pickedDate.set(year, months, day)
                val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                dateFormat = format.format(pickedDate.time)
                binding.reminderDateTxt.text = dateFormat
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        dateDialog.setButton(
            DialogInterface.BUTTON_NEGATIVE, "Cancel"
        ) { _, it ->
            if (it == DialogInterface.BUTTON_NEGATIVE) {
                binding.radioDebit.isChecked = true
                entryType = 1
                dateFormat = ""
            }
        }
        dateDialog.datePicker.minDate = calendar.timeInMillis
        dateDialog.show()
        binding.reminderDateTxt.setCompoundDrawables(null, null, null, null)
    }

    private fun currentDatePicker() {
        val dateDialog = DatePickerDialog(
            this, { _, year, months, day ->
                val pickedDate = Calendar.getInstance()
                pickedDate.set(year, months, day)
                val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                dateFormat = format.format(pickedDate.time)
                binding.reminderDateTxt.text = dateFormat
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        dateDialog.setButton(
            DialogInterface.BUTTON_NEGATIVE, "Cancel"
        ) { _, it ->
            if (it == DialogInterface.BUTTON_NEGATIVE) {
                binding.radioDebit.isChecked = true
                entryType = 1
                dateFormat = ""
            }
        }
        dateDialog.datePicker.maxDate = calendar.timeInMillis
        dateDialog.show()
        binding.reminderDateTxt.setCompoundDrawables(null, null, null, null)
    }

    @SuppressLint("SetTextI18n")
    private fun paymentType() {
        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.radioDebit.id -> {
                    binding.paymentReminderView.visibility = View.GONE
                    entryType = 1
                }

                binding.radioCredit.id -> {
                    binding.paymentReminderView.visibility = View.VISIBLE
                    entryType = 2

                }
            }
        }
    }
}
