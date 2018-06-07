package com.example.elgrim.seasonal

import android.app.DatePickerDialog
import android.content.SharedPreferences
import android.support.design.widget.TabLayout

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.util.Log

import android.view.Menu
import android.view.MenuItem
import com.example.elgrim.seasonal.candidate.CandidateFragmentDetail
import com.example.elgrim.seasonal.candidate.CandidateFragmentList

import kotlinx.android.synthetic.main.candidate_fragment_container.*
import java.text.SimpleDateFormat
import android.view.*
import com.beust.klaxon.Klaxon
import com.example.elgrim.seasonal.http.APIController
import com.example.elgrim.seasonal.http.ServiceVolley
import com.example.elgrim.seasonal.model.Candidate
import com.example.elgrim.seasonal.model.CandidateParcelableList
import com.example.elgrim.seasonal.shared.LoadingFragment
import com.example.elgrim.seasonal.utils.PreferenceHelper
import com.example.elgrim.seasonal.utils.PreferenceHelper.get
import java.util.*
import kotlin.collections.ArrayList


class CandidateList : Fragment() {

    private lateinit var prefs: SharedPreferences
    private var candidates: CandidateParcelableList? = null

    val loadingFragment: LoadingFragment by lazy {
        LoadingFragment()
    }

    companion object {
        fun newInstance(): CandidateList = CandidateList()
    }

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private var calendar: Calendar = Calendar.getInstance()
    private val dateFormater: SimpleDateFormat by lazy {
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        prefs = PreferenceHelper.defaultPrefs(this.activity)
        getCandidates()
        return inflater.inflate(R.layout.candidate_fragment_container, container, false)
    }

    private fun getCandidates() {

        showLoadingFragment()

        val service = ServiceVolley()
        val apiController = APIController(service)
        apiController.get("candidates/", prefs[Constants.TOKEN]) { response ->

            if (response != null) {
                val result = Klaxon().parseArray<Candidate>(response.toString())
                candidates = CandidateParcelableList(result)
            }

            mSectionsPagerAdapter = SectionsPagerAdapter(childFragmentManager)

            container.adapter = mSectionsPagerAdapter
            tabs.setupWithViewPager(container)

            hideLoadingFragment()
        }
    }

    private fun showLoadingFragment() {
        childFragmentManager.beginTransaction().add(R.id.main_content, loadingFragment, "loading_fragment").commit()
    }

    private fun hideLoadingFragment() {
        childFragmentManager.beginTransaction().remove(loadingFragment).commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val date = calendar.time
            val timeText = dateFormater.format(date)
            updateDateInView()

        }

        candidate_filter_date.setOnClickListener {
            DatePickerDialog(this.context,
                    dateSetListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        /* candidate_filter_date.setOnClickListener(object : View.OnClickListener {
             override fun onClick(view: View) {
                 DatePickerDialog(context,
                 dateSetListener,
                 calendar.get(Calendar.YEAR),
                 calendar.get(Calendar.MONTH),
                 calendar.get(Calendar.DAY_OF_MONTH)).show()
             }
         })*/

        container.adapter = mSectionsPagerAdapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_candidate_list_fragmentactivity_main, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> {
                    val bundle = Bundle()
                    bundle.putParcelable("CandidatesParcelableList", candidates)
                    Log.d("CA", candidates.toString())
                    val fragment = CandidateFragmentList()
                    fragment.arguments = bundle
                    return fragment
                }

                1 -> {
                    val bundle = Bundle()
                    bundle.putParcelable("CandidatesParcelableList", candidates)
                    val fragment = CandidateFragmentDetail()
                    fragment.arguments = bundle
                    return fragment
                }
                else -> return null
            }
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "Liste"
                1 -> return "Détail"
            }

            return null
        }
    }

    private fun updateDateInView() {
        val myFormat = "dd/MM" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.FRENCH)
        candidate_filter_date.text = sdf.format(calendar.time)
    }
}

