package com.example.elgrim.seasonal

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_register_candidate.*
import com.example.elgrim.seasonal.helpers.FormValidate
import com.example.elgrim.seasonal.model.Candidate
import com.example.elgrim.seasonal.model.Job
import com.example.elgrim.seasonal.model.User


fun Map<String, String>.getNotNull(key: String): String {
    return get(key) ?: ""
}

class RegisterCandidateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_candidate)

        registerCandidateStep1.isChecked = true

        registerCandidateStep2.setOnClickListener {
            val intent = Intent(this, RegisterCandidate2Activity::class.java)
            val data = getData()
            if (validateData(data)) {
                val candidateCreate = Candidate(User(1, data["lastName"].toString(), data["firstName"].toString(), data["email"].toString()), 0, "", 0, 0, "", "", Job(0, ""), 0)
                intent.putExtra("step1_data", candidateCreate)
                startActivity(intent)
            } else {
                registerCandidateStep1.isChecked = true
            }
        }
        registerCandidateStep3.setOnClickListener {
            val intent = Intent(this, RegisterCandidate3Activity::class.java)
            startActivity(intent)
        }
    }

    private fun getData(): Map<String, String> {
        val lastName: String = registerEditLastName.text.toString()
        val firstName: String = registerEditFirstName.text.toString()
        val email: String = registerEditEmail.text.toString()
        val password: String = registerEditPassword.text.toString()
        val registerEditCity: String = registerEditCity.text.toString()

        return mapOf("lastName" to lastName,
                "firstName" to firstName,
                "email" to email,
                "password" to password,
                "city" to registerEditCity)
    }

    private fun validateData(data: Map<String, String>): Boolean {
        var validator = FormValidate()
        val errorTitle = resources.getString(R.string.validationFormError)

        for ((key, value) in data) {
            if (!(value ?: "").isNotEmpty()) {
                validator.errorHandler(this, errorTitle,
                        resources.getString(R.string.validationWrong) + key)
                return false
            }
        }
        var isValid = validator.isEmailValid(data.getNotNull("email"))
        if (!validator.isEmailValid(data.getNotNull("email"))) {
            validator.errorHandler(this, errorTitle,
                    resources.getString(R.string.validationEmailWrong))
            return false
        }

        return true
    }
}
