package com.example.elgrim.seasonal

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_register_candidate.*
import com.example.elgrim.seasonal.helpers.FormValidate


fun Map<String, String?>.getNotNull(key: String): String {
    return get(key) ?: ""
}

class RegisterCandidateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_candidate)
    }

    private fun getData(): Map<String, String?> {
        val lastName: String? = registerEditLastName.text.toString()
        val firstName: String? = registerEditFirstName.text.toString()
        val email: String? = registerEditEmail.text.toString()
        val password: String? = registerEditPassword.text.toString()

        return mapOf("lastName" to lastName,
                "firstName" to firstName,
                "email" to email,
                "password" to password)
    }

    private fun validateData(data: Map<String, String?>): Boolean {
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
