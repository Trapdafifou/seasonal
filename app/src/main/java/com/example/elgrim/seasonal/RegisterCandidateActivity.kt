package com.example.elgrim.seasonal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_candidate.*
import com.example.elgrim.seasonal.helpers.FormValidate


fun Map<String, String?>.getNotNull(key: String): String {
    return get(key) ?: ""
}

class RegisterCandidateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_candidate)

        registerButtonSubmitRegisterCandidate.setOnClickListener {
            val registerData = validateData(getData())
        }
    }

    private fun getData(): Map<String, String?> {
        val lastName: String? = registerEditLastName.text.toString()
        val firstName: String? = registerEditFirstName.text.toString()
        val email: String? = registerEditEmail.text.toString()
        val password: String? = registerEditPassword.text.toString()

        lateinit var data: Map<String, String?>

        data = mapOf("lastName" to lastName,
                "firstName" to firstName,
                "email" to email,
                "password" to password)

        return data
    }

    private fun validateData(data: Map<String, String?>): Boolean {
        var validator = FormValidate()
        val errorTitle = "Erreur lors de l'enregistrement"

        for ((key, value) in data) {
            if (!(value ?: "").isNotEmpty()) {
                validator.errorHandler(this, errorTitle,
                        "Veuillez remplir le $key")
                return false
            }
        }
        var isValid = validator.isEmailValid(data.getNotNull("email"))
        if (!validator.isEmailValid(data.getNotNull("email"))) {
            validator.errorHandler(this, errorTitle,
                    "Veuillez remplir un email valide")
            return false
        }

        return true
    }
}
