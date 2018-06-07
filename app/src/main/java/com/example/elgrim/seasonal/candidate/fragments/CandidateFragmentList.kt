package com.example.elgrim.seasonal.candidate.fragments

import android.content.SharedPreferences
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elgrim.seasonal.R
import com.example.elgrim.seasonal.adapter.CandidateAdapterList
import com.example.elgrim.seasonal.candidate.CandidateDetail
import com.example.elgrim.seasonal.model.Candidate
import com.example.elgrim.seasonal.utils.PreferenceHelper
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.fragment_candidate_list.*


class CandidateFragmentList : BaseCandidateFragment() {

    override lateinit var prefs: SharedPreferences
    override var candidates: ArrayList<Candidate>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_candidate_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prefs = PreferenceHelper.defaultPrefs(this.activity)
        professional_recycler_list.layoutManager = LinearLayoutManager(context)
        val itemAdapter = FastItemAdapter<CandidateAdapterList>()
        itemAdapter.add(candidates?.map { CandidateAdapterList(it) })

        professional_recycler_list.adapter = itemAdapter

        itemAdapter.withOnClickListener({ _, _, item, _ ->
            val candidate = item.candidate
            val intent = Intent(this.context, CandidateDetail::class.java)
            intent.putExtra("candidate_EXTRA", candidate)
            startActivity(intent)
            true
        })
    }

    override fun setCantidate(candidatesData: ArrayList<Candidate>) {
        this.candidates = candidatesData
    }

}

