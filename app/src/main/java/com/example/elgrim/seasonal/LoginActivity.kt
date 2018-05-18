package com.example.elgrim.seasonal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject


class LoginActivity : AppCompatActivity() {

    val url_request = "127.0.0.1:3000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_submit.setOnClickListener {
            val email = login_email.text
            val password = login_password.text

            val jsonObject = JSONObject()
            jsonObject.put("email", email)
            jsonObject.put("password", password)

            val objectRequest = JsonObjectRequest(Request.Method.POST, url_request, jsonObject,
                    Response.Listener { response ->
                        Log.d("Success", "Response: %s".format(response.toString()) )
                    },

                    Response.ErrorListener { error ->
                        Log.e("Err", error.toString())
                    }
            )

            HttpSingleton.getInstance(this).addToRequestQueue(objectRequest)
        }
    }
}

