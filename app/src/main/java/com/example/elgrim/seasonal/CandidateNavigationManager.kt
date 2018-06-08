package com.example.elgrim.seasonal

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.design.widget.BottomNavigationView
import com.example.elgrim.seasonal.profil.CandidateFragmentProfile
import com.example.elgrim.seasonal.profil.ProfilFragment
import kotlinx.android.synthetic.main.navigation_main_candidate.*

class CandidateNavigationManager: AppCompatActivity() {
    val candidateProfilFragment: CandidateFragmentProfile by lazy {
        CandidateFragmentProfile.newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_main_candidate)
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        openFragment(candidateProfilFragment)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.profile_candidate-> {
                openFragment(candidateProfilFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.navigationView, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}