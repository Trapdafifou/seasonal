package com.example.elgrim.seasonal

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.elgrim.seasonal.http.APIController
import com.example.elgrim.seasonal.http.ServiceVolley
import com.example.elgrim.seasonal.utils.PreferenceHelper
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.json.JSONObject
import com.example.elgrim.seasonal.utils.PreferenceHelper.get
import com.example.elgrim.seasonal.utils.PreferenceHelper.set

class LoginActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        prefs = PreferenceHelper.defaultPrefs(this)
        login_button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val email = login_email.text
        val password = login_password.text

        if (email.isNotEmpty() && password.isNotEmpty()) {
            // https://www.varvet.com/blog/kotlin-with-volley/
            val service = ServiceVolley()
            val apiController = APIController(service)

            val params = JSONObject()
            params.put("email", email)
            params.put("password", password)

            apiController.post("rest-auth/login/", null, params) { response ->
                if (response != null) {
                    prefs[Constants.TOKEN] = response.get("key")
                    val intent = Intent(this, CandidateListActivity::class.java)
                    startActivity(intent)
                } else {
                    alert(R.string.login_error_request) {
                        noButton { }
                    }.show()
                }
            }
        } else {
            alert(R.string.login_miss_input) {
                noButton { }
            }.show()
        }
    }
}

