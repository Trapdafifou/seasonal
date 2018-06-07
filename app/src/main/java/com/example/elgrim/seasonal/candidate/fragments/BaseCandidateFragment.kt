package com.example.elgrim.seasonal.candidate.fragments

import android.content.SharedPreferences
import android.support.v4.app.Fragment
import com.example.elgrim.seasonal.model.Candidate

abstract class BaseCandidateFragment : Fragment() {

    abstract var candidates: ArrayList<Candidate>?
    abstract var prefs: SharedPreferences


    open fun setCantidate(candidatesData: ArrayList<Candidate>) {
        this.candidates = candidatesData
    }
}