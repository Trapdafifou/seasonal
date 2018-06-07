package com.example.elgrim.seasonal.profil


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.elgrim.seasonal.R


class ProfilFragment : Fragment() {
    companion object {
        fun newInstance(): ProfilFragment = ProfilFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_profil_edit, container, false)
    }


}
