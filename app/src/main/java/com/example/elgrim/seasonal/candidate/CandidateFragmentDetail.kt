package com.example.elgrim.seasonal.candidate

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elgrim.seasonal.R
import com.example.elgrim.seasonal.adapter.CandidateAdapterDetail
import com.example.elgrim.seasonal.model.Candidate
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.fragment_candidate_detail.*
import java.util.*

class CandidateFragmentDetail: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_candidate_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val candidates = arrayListOf<Candidate>()
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 2, Date(), "cuisine", 2, 2000, "Je m’appelle Alexandre et je recherche un petit job pour financer mes études. J’ai déjà travaillé dans plusieurs établissements ! ", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 2, Date(), "cuisine", 2, 2000, "Je m’appelle Alexandre et je recherche un petit job pour financer mes études. J’ai déjà travaillé dans plusieurs établissements ! ", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))

        professional_recycler_detail.layoutManager = LinearLayoutManager(context)
        val itemAdapter = FastItemAdapter<CandidateAdapterDetail>()
        itemAdapter.add(candidates.map { CandidateAdapterDetail(it) })

        professional_recycler_detail.adapter = itemAdapter
    }
}