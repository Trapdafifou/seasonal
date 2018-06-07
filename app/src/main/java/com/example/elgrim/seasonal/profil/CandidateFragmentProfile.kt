package com.example.elgrim.seasonal.profil


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elgrim.seasonal.R
import kotlinx.android.synthetic.main.fragment_candidate_profil.*

class CandidateFragmentProfile: Fragment() {
    companion object {
        fun newInstance(): CandidateFragmentProfile = CandidateFragmentProfile()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_candidate_profil, container, false)
    }

/*    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        candidate_pro_detail_desc.text = "ezaezzeazezaeeaz"
    }*/
}