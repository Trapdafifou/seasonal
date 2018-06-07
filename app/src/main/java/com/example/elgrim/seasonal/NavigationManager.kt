package com.example.elgrim.seasonal

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.navigation_main.*

class NavigationManager: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_main)
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        Log.d("eazeaze", item.itemId.toString())
        when (item.itemId) {
            R.id.home-> {
                val candidateFragment = CandidateList.newInstance()
                openFragment(candidateFragment)
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
        transaction.replace(R.id.navigation_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}