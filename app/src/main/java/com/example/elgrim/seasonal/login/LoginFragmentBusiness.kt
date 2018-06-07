package com.example.elgrim.seasonal.login

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elgrim.seasonal.*
import com.example.elgrim.seasonal.http.APIController
import com.example.elgrim.seasonal.http.ServiceVolley
import com.example.elgrim.seasonal.utils.PreferenceHelper
import com.example.elgrim.seasonal.utils.PreferenceHelper.set
import kotlinx.android.synthetic.main.fragment_login_fragment_business.*
import org.json.JSONObject

class LoginFragmentBusiness : Fragment(), View.OnClickListener {
    lateinit private var prefs: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        prefs = PreferenceHelper.defaultPrefs(this.activity)
        return inflater.inflate(R.layout.fragment_login_fragment_business, container, false)
    }

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        login_button.setOnClickListener(this)
        login_buisiness_signin.setOnClickListener {
            val intent = Intent(this.context, RegisterCandidateActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {
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
                    val intent = Intent(this.context, NavigationManager::class.java)
                    startActivity(intent)
                } else {
                    AlertDialog.Builder(this.context)
                            .setTitle(R.string.login_error_request)
                            .create()
                            .show()
                }
            }
        } else {
            AlertDialog.Builder(this.context)
                    .setTitle(R.string.login_miss_input)
                    .create()
                    .show()
        }
    }
}
