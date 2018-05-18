package com.example.elgrim.seasonal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_candidate.*
import java.util.*
import kotlin.collections.ArrayList
import com.example.elgrim.seasonal.helpers.FormValidate


fun Map<String, String?>.getNotNull(key: String): String {
    return get(key) ?: ""
}

class RegisterCandidateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_candidate)

        buttonSubmitRegisterCandidate.setOnClickListener {
            val registerData = this.getData()
        }
    }

    private fun getData() {
        val lastName: String? = editLastName.text.toString()
        val firstName: String? = editFirstName.text.toString()
        val email: String? = editEmail.text.toString()
        val password: String? = editPassword.text.toString()

        lateinit var data: Map<String, String?>

        data = mapOf("lastName" to lastName,
                "firstName" to firstName,
                "email" to email,
                "password" to password)
        validateData(data)
    }

    private fun validateData(data: Map<String, String?>) {
        var validator = FormValidate()

        if(data.getNotNull("email").isNotEmpty() && validator.isEmailValid(data.getNotNull("email"))) {
            println(data.getNotNull("email"))
        }
    }
}
