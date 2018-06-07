package com.example.elgrim.seasonal.profil


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elgrim.seasonal.Constants

import com.example.elgrim.seasonal.R
import com.example.elgrim.seasonal.model.Candidate
import com.example.elgrim.seasonal.model.Job
import com.example.elgrim.seasonal.model.User
import com.example.elgrim.seasonal.utils.month
import com.hendraanggrian.pikasso.circle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_candidate_detail.*


class ProfilFragment : Fragment() {
    companion object {
        fun newInstance(): ProfilFragment = ProfilFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = User(1, "Alexandre", "Vagnair", "alexandre.vagnair@hetic.net")
        val job = Job(2,"Commit")
        val candidate = Candidate(user, 3, "2018-06-06T20:04:48Z", 5, 1300,"https://scontent-cdg2-1.xx.fbcdn.net/v/t1.0-9/16426195_933773246759285_2164964073072725179_n.jpg?_nc_cat=0&oh=d3340efce4d595e2ca45616e526c7140&oe=5BBA2BD9", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus eu justo eu ante gravida commodo vel et nisi. Cras in viverra eros. Ut sollicitudin iaculis laoreet. Fusce porta at ante eget ullamcorper. In neque nisl, rutrum id tellus quis, volutp",job,1 )
        Picasso.get().load(candidate.profile_picture ?: Constants.PLACEHOLDER_URL).circle().into(candidate_detail_img)
        candidate_detail_job.text = candidate.job.name
        candidate_detail_name.text = "${candidate.user.first_name} ${candidate.user.last_name}"
        candidate_detail_weight.text = "${candidate.wage_claim}€"
        candidate_detail_exp.text = "${candidate.year_exp} années d'xp"
        candidate_detail_date.text ="à partir du : " +month(candidate.available_at)
        candidate_detail_place.text = "Paris"
        candidate_detail_desc.text = candidate.description
        candidate_detail_title_page.text = "Profil de ${candidate.user.first_name} ${candidate.user.last_name}"

        candidtae_detail_roleback.setBackgroundColor(Color.TRANSPARENT)
        candidtae_detail_roleback.setOnClickListener {
            fragmentManager!!.popBackStack()
        }

    }
}
