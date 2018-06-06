package com.example.elgrim.seasonal.candidate

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elgrim.seasonal.Constants
import com.example.elgrim.seasonal.R
import com.example.elgrim.seasonal.R.id.professional_recycler_list
import com.example.elgrim.seasonal.adapter.CandidateAdapterList
import com.example.elgrim.seasonal.http.APIController
import com.example.elgrim.seasonal.http.ServiceVolley
import com.example.elgrim.seasonal.model.Candidate
import com.example.elgrim.seasonal.utils.PreferenceHelper
import com.example.elgrim.seasonal.utils.PreferenceHelper.get
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Types


class CandidateFragmentList : Fragment() {
    //get any value from prefs

    private lateinit var prefs: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        prefs = PreferenceHelper.defaultPrefs(this.activity)
        getCandidates()
        return inflater.inflate(R.layout.fragment_candidate_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val candidates = arrayListOf<Candidate>()
        professional_recycler_list.layoutManager = LinearLayoutManager(context)
        val itemAdapter = FastItemAdapter<CandidateAdapterList>()
        itemAdapter.add(candidates.map { CandidateAdapterList(it) })

        professional_recycler_list.adapter = itemAdapter
    }

    private fun getCandidates() {
        val service = ServiceVolley()
        val apiController = APIController(service)
        apiController.get("candidates/", prefs[Constants.TOKEN]) { response ->
            if (response != null) {
                val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                Log.d("res", response.toString())
                val type = Types.newParameterizedType(ArrayList::class.java, Candidate::class.java)
                //val adapter = moshi.adapter(type)
                //val cards = adapter.fromJson(cardsJsonResponse)
            }
        }
    }
}