package com.example.elgrim.seasonal

import android.content.Intent
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.elgrim.seasonal.http.APIController
import com.example.elgrim.seasonal.http.ServiceVolley
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.json.JSONObject


class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        Log.d("view", view.toString())
        val email = login_email.text
        val password = login_password.text

        if (email.isNotEmpty() && password.isNotEmpty()) {
            // https://www.varvet.com/blog/kotlin-with-volley/
            val service = ServiceVolley()
            val apiController = APIController(service)

            val params = JSONObject()
            params.put("email", email)
            params.put("password", password)

            apiController.post("rest-auth/login/", params) { response ->
                if (response != null) {
                    val datas = response.get("key").toString()
                    val intent = Intent(this, CandidateList::class.java)
                    intent.putExtra("token", datas)
                    startActivity(intent)
                } else {
                    alert(R.string.login_miss_input) {
                        noButton { }
                    }.show()
                }
            }
        }
    }
}

