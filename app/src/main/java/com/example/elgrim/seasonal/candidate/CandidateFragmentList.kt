package com.example.elgrim.seasonal.candidate

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elgrim.seasonal.R
import com.example.elgrim.seasonal.adapter.CandidateAdapterList
import com.example.elgrim.seasonal.model.Candidate
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.fragment_candidate_list.*
import java.util.*

class CandidateFragmentList: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_candidate_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val candidates = arrayListOf<Candidate>()
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), "cuisine", 2, 2000, "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est ", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))
        candidates.add(Candidate(1, "alexandre", "vagnair", "alexandre.vagniar@hetic.net", "eaeaze", "ezaeze", 12, Date(), "cuisine", 2, 2000, "dqsdqd", "https://www.gettyimages.ie/gi-resources/images/Homepage/Hero/UK/CMS_Creative_164657191_Kingfisher.jpg"))

        professional_recycler_list.layoutManager = LinearLayoutManager(context)
        val itemAdapter = FastItemAdapter<CandidateAdapterList>()
        itemAdapter.add(candidates.map { CandidateAdapterList(it) })

        professional_recycler_list.adapter = itemAdapter
    }
}