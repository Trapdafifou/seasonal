package com.example.elgrim.seasonal.candidate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.elgrim.seasonal.HttpSingleton
import com.example.elgrim.seasonal.R
import com.example.elgrim.seasonal.adapter.CandidateAdapter
import com.example.elgrim.seasonal.model.Candidate
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.mikepenz.fastadapter.listeners.OnClickListener
import kotlinx.android.synthetic.main.activity_seasonal_list.*
import java.util.*

class CandidateList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seasonal_list)

        val objectRequest = JsonObjectRequest(Request.Method.GET, "https://seasonal-api.herokuapp.com/api/v1/candidates/", null,
                Response.Listener {response ->
                    Log.d("Error", response.toString())

                },
                Response.ErrorListener {error ->
                    Log.d("Error", error.toString())
                })
        HttpSingleton.getInstance(this).addToRequestQueue(objectRequest)

        val candidates = arrayListOf<Candidate>()
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), 1, 2, 2000, "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est ", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), 1, 2, 2000, "dqsdqd", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), 1, 2, 2000, "dqsdqd", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), 1, 2, 2000, "dqsdqd", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), 1, 2, 2000, "dqsdqd", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), 1, 2, 2000, "dqsdqd", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), 1, 2, 2000, "dqsdqd", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), 1, 2, 2000, "dqsdqd", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), 1, 2, 2000, "dqsdqd", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), 1, 2, 2000, "dqsdqd", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))

        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        professional_recycler.layoutManager = linearLayoutManager
        val itemAdapter = FastItemAdapter<CandidateAdapter>()
        itemAdapter.add(candidates.map { CandidateAdapter(it) })

        professional_recycler.adapter = itemAdapter

        itemAdapter.withOnClickListener(OnClickListener{
            v, adapter, item, position ->
            val candidate = item.candidate
            val intent = Intent(this, CandidateDetail::class.java)
            intent.putExtra("candidate_EXTRA", candidate)
            startActivity(intent)
            true
        })
    }
}
