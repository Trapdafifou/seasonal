package com.example.elgrim.seasonal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_candidate3.*

class RegisterCandidate3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_candidate3)

        registerCandidateStep3.isChecked = true

        registerCandidateStep1.setOnClickListener {
            val intent = Intent(this, RegisterCandidateActivity::class.java)
            startActivity(intent)
        }
        registerCandidateStep2.setOnClickListener {
            val intent = Intent(this, RegisterCandidate2Activity::class.java)
            startActivity(intent)
        }
    }
}
