package com.example.elgrim.seasonal

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.elgrim.seasonal.profil.ProfilFragment
import kotlinx.android.synthetic.main.navigation_main.*

class NavigationManager: AppCompatActivity() {

    val candidateFragment: CandidateList by lazy {
        CandidateList.newInstance()
    }

    val profilFragment: ProfilFragment by lazy {
        ProfilFragment.newInstance()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_main)
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        openFragment(candidateFragment)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        Log.d("eazeaze", item.itemId.toString())
        when (item.itemId) {
            R.id.home-> {
                openFragment(candidateFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile -> {
                openFragment(profilFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.navigation_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}