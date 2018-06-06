package com.example.elgrim.seasonal.candidate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.elgrim.seasonal.R
import com.example.elgrim.seasonal.model.Candidate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_candidate_detail.*
import java.text.SimpleDateFormat
import java.util.*

class CandidateDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidate_detail)

        val candidate = intent.getParcelableExtra<Candidate>("candidate_EXTRA")
        Picasso.get().load(candidate.profile_picture_url).into(candidate_detail_img)
        candidate_detail_job.text = candidate.job_name.toString()
        candidate_detail_name.text = candidate.firstname + " " + candidate.lastname
        candidate_detail_exp.text = candidate.year_exp.toString()
        candidate_detail_date.text = format(candidate.available_at)
        candidate_detail_place.text = "Paris"
        candidate_detail_desc.text = candidate.description
    }
}
private fun format(available_at: Date?): String? {
    val format = SimpleDateFormat("dd/MM/yyy")
    return format.format(available_at)
}
