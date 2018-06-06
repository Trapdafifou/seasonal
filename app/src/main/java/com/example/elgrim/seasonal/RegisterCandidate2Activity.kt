package com.example.elgrim.seasonal

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_register_candidate2.*
import java.util.Locale

class RegisterCandidate2Activity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    object DataPopulate {
        val experienceValues: List<Number> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
        val wageValues: List<Number> = arrayListOf(
                500,
                1000,
                1500,
                2000,
                2500,
                3000
        )
    }
    var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_candidate2)

        registerJobDateSpinner.text = "--/--"

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }

        registerJobDateSpinner.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@RegisterCandidate2Activity,
                        dateSetListener,
                        // set DatePickerDialog to point to today's date when it loads up
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show()
            }

        })
        populateSpinner(registerExperienceValueSpinner, DataPopulate.experienceValues)
        populateSpinner(registerWageValueSpinner, DataPopulate.wageValues)
    }

    private fun populateSpinner (spinner: Spinner, populate_item: List<Any>) {
        spinner.setOnItemSelectedListener(this)

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, populate_item)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner.setAdapter(aa)

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        //To change body of created functions use File | Settings | File Templates.
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.FRENCH)
        registerJobDateSpinner!!.text = sdf.format(calendar.getTime())
    }
}
