package com.example.elgrim.seasonal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.elgrim.seasonal.candidate.CandidateList
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.json.JSONObject


class LoginActivity : AppCompatActivity() {

    val url_request = "https://seasonal-api.herokuapp.com/api/v1/rest-auth/login/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener {
            val email = login_email.text
            val password = login_password.text

            if  (email.isNotEmpty() && password.isNotEmpty() ) {
                val intent = Intent(this, CandidateList::class.java)
                startActivity(intent)

/*                val jsonObject = JSONObject()
                jsonObject.put("email", email)
                jsonObject.put("password", password)

                val objectRequest = JsonObjectRequest(Request.Method.POST, url_request, jsonObject,
                        Response.Listener { response ->
                            if (response.toString().isBlank()) {}
                            else {
                                val datas = response.get("key").toString()
                                val intent = Intent(this, CandidateList::class.java)
                                intent.putExtra("token", datas)

                                startActivity(intent)
                            }
                        },

                        Response.ErrorListener { error ->
                            Log.d("Error", "%s".format(error.toString()))
                            alert("Une erreur est survenu veuillez réassayer plus tard merci !") {
                                noButton {  }
                            }.show()
                        }
                )

                HttpSingleton.getInstance(this).addToRequestQueue(objectRequest)*/
            }else {
                alert("Les champs email et mot de passe son obligratoire") {
                    noButton {  }
                }.show()
            }

        }



    }
}

