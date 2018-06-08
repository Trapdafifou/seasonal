package com.example.elgrim.seasonal

import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.elgrim.seasonal.http.APIController
import com.example.elgrim.seasonal.http.ServiceVolley
import com.example.elgrim.seasonal.model.Candidate
import kotlinx.android.synthetic.main.activity_register_candidate3.*
import org.json.JSONObject

class RegisterCandidate3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_candidate3)

        val bundle = getIntent().getExtras()
        val candidateData: Candidate = bundle.get("step2_data") as Candidate

        registerCandidateStep3.isChecked = true

        registerCandidateStep1.setOnClickListener {
            val intent = Intent(this, RegisterCandidateActivity::class.java)
            startActivity(intent)
        }
        registerCandidateStep2.setOnClickListener {
            val intent = Intent(this, RegisterCandidate2Activity::class.java)
            startActivity(intent)
        }

        registerCandidateReviewIdentity.text = candidateData.user.first_name + " " + candidateData.user.last_name
        registerCandidateReviewEmail.text = candidateData.user.email
        registerCandidateReviewCity.text = candidateData.user.city
        registerCandidateReviewAvailability.text = candidateData.available_at

        candidateRegisterButton.setOnClickListener {
            candidateRegister(candidateData)
        }
    }

    private fun candidateRegister(data: Candidate) {
        val service = ServiceVolley()

        val params = JSONObject()
        params.put("user", data.user)
        params.put("year_exp", data.year_exp)
        params.put("available_at", data.available_at)
        params.put("wage_claim", data.wage_claim)
        params.put("job_id", data.job_id)

        val apiController = APIController(service)
        apiController.post("/api/v1/candidates/", "", params) { response ->
            if (response != null) {
                val intent = Intent(this, CandidateNavigationManager::class.java)
                startActivity(intent)
            } else {
                AlertDialog.Builder(this)
                        .setTitle(R.string.login_error_request)
                        .create()
                        .show()
            }
        }
    }
}
