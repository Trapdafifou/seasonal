package com.example.elgrim.seasonal

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.*
import com.example.elgrim.seasonal.adapter.JobTagAdapter
import com.example.elgrim.seasonal.model.Candidate
import com.example.elgrim.seasonal.model.Job
import kotlinx.android.synthetic.main.activity_register_candidate2.*
import java.util.*

class RegisterCandidate2Activity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    object DataPopulate {
        val experienceValues: MutableList<Number> = arrayListOf()
        val wageValues: MutableList<Number> = arrayListOf()
    }

    val jobsTabs: ArrayList<String> = ArrayList()
    var experience: Int = 0

    var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_candidate2)

        val bundle = getIntent().getExtras()
        val candidateData: Candidate = bundle.get("step1_data") as Candidate


        if (DataPopulate.experienceValues.isEmpty()) {
            for (i in 1..12) {
                DataPopulate.experienceValues.add(i)
            }
        }

        if (DataPopulate.wageValues.isEmpty()) {
            for (i in 500..3000 step 500) {
                DataPopulate.wageValues.add(i)
            }
        }

        registerJobDateSpinner.text = resources.getString(R.string.baseDateInput)

        getJobsTag(jobsTabs)
        registerTagsRecyclerView.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        registerTagsRecyclerView.adapter = JobTagAdapter(jobsTabs, this)

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


        registerCandidateStep2.isChecked = true

        registerCandidateStep1.setOnClickListener {
            val intent = Intent(this, RegisterCandidateActivity::class.java)
            startActivity(intent)
        }
        registerCandidateStep3.setOnClickListener {
            val intent = Intent(this, RegisterCandidate3Activity::class.java)
            intent.putExtra("step2_data", bindData(candidateData))
            startActivity(intent)
        }
    }

    private fun populateSpinner(spinner: Spinner, populate_item: List<Any>) {
        spinner.setOnItemSelectedListener(this)

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val Adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, populate_item)
        // Set layout to use when the list of choices appear
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner.setAdapter(Adapter)

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
        registerJobDateSpinner.text = sdf.format(calendar.getTime())
    }

    private fun bindData(candidate: Candidate): Candidate {
        val experience = registerExperienceValueSpinner.selectedItemPosition + 1
        val available_at = registerJobDateSpinner.text.toString()
        val wage_claim = registerWageValueSpinner.selectedItemPosition * 500

        return Candidate(candidate.user, experience, available_at, 0, wage_claim, "", "", Job(0, ""), 0)
    }

    private fun getJobsTag(datas: List<String>) {

        jobsTabs.add("Serveur")
        jobsTabs.add("Commis")
        jobsTabs.add("Mixologue")
        jobsTabs.add("Videur")

        for (data in datas) {

        }
    }
}
