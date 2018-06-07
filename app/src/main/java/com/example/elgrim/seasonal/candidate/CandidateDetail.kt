package com.example.elgrim.seasonal.candidate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.elgrim.seasonal.Constants
import com.example.elgrim.seasonal.R
import com.example.elgrim.seasonal.model.Candidate
import com.hendraanggrian.pikasso.circle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_candidate_detail.*
import com.example.elgrim.seasonal.utils.format

class CandidateDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate_detail)

        val candidate = intent.getParcelableExtra<Candidate>("candidate_EXTRA")
        Picasso.get().load(candidate.profile_picture ?: Constants.PLACEHOLDER_URL).into(candidate_detail_img)
        candidate_detail_job.text = candidate.job.name
        candidate_detail_name.text = "${candidate.user.first_name} ${candidate.user.last_name}"
        candidate_detail_weight.text = "${candidate.wage_claim}€"
        candidate_detail_exp.text = candidate.year_exp.toString()
        candidate_detail_date.text = format(candidate.available_at)
        candidate_detail_place.text = "Paris"
        candidate_detail_desc.text = candidate.description
    }
}
