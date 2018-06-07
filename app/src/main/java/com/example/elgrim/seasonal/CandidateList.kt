package com.example.elgrim.seasonal

import android.app.DatePickerDialog
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle

import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import com.example.elgrim.seasonal.candidate.CandidateFragmentDetail
import com.example.elgrim.seasonal.candidate.CandidateFragmentList

import kotlinx.android.synthetic.main.candidate_fragment_container.*
import java.text.SimpleDateFormat
import android.text.Editable
import android.util.Log
import android.view.*
import java.util.*


class CandidateList : Fragment() {
    companion object {
        fun newInstance(): CandidateList = CandidateList()
    }

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private var calendar: Calendar = Calendar.getInstance()
    private val dateFormater: SimpleDateFormat by lazy {
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.candidate_fragment_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mSectionsPagerAdapter = SectionsPagerAdapter(childFragmentManager)

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            //val date = calendar.time
            //val timeText = dateFormater.format(date)
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
            return when (position) {
                0 -> {
                    CandidateFragmentList()
                }

                1 -> {
                    CandidateFragmentDetail()
                }
                else -> null
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
        candidate_filter_date.text = sdf.format(calendar.getTime())
    }
}

