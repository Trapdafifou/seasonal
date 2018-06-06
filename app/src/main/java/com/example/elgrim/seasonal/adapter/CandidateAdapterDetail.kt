package com.example.elgrim.seasonal.adapter

import android.os.Build
import android.support.annotation.RequiresApi
import android.view.View
import com.example.elgrim.seasonal.R
import com.example.elgrim.seasonal.model.Candidate
import com.hendraanggrian.pikasso.circle
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.candidate_recycler_detail.view.*
import kotlinx.android.synthetic.main.candidate_recycler_list.view.*
import java.text.SimpleDateFormat
import java.util.*

class CandidateAdapterDetail (val candidate: Candidate) : AbstractItem<CandidateAdapterDetail, CandidateAdapterDetail.CandidateViewHolder>() {
     override fun getType(): Int {
         return R.id.professional_item_date
     }

    override fun getViewHolder(v: View?): CandidateViewHolder {
        return CandidateViewHolder(v)
    }

    override fun getLayoutRes(): Int {
        return R.layout.candidate_recycler_detail
    }

    class CandidateViewHolder(itemView: View?) : FastAdapter.ViewHolder<CandidateAdapterDetail>(itemView) {
        override fun unbindView(item: CandidateAdapterDetail?) {
            itemView.candidate_detail_name.text = null
            itemView.candidate_detail_exp.text = null
            itemView.candidate_detail_date.text = null
            itemView.candidate_detail_place.text = null
            itemView.candidate_detail_job.text = null
            itemView.candidate_detail_desc.text = null
            itemView.candidate_detail_weight.text = null
        }

        @RequiresApi(Build.VERSION_CODES.O)
        override fun bindView(item: CandidateAdapterDetail?, payloads: MutableList<Any>?) {
            val candidate = item?.candidate
            itemView.candidate_detail_name.text = candidate?.user?.firstname
            itemView.candidate_detail_exp.text = candidate?.year_exp.toString() + " années d'xp"
            itemView.candidate_detail_date.text = format(candidate?.available_at)
            itemView.candidate_detail_job.text = candidate?.job_name
            itemView.candidate_detail_place.text = "Paris"
            itemView.candidate_detail_desc.text = candidate?.description
            itemView.candidate_detail_weight.text = candidate?.wage_claim.toString() + "€"
            Picasso.get().load(candidate?.profile_picture).circle().into(itemView.candidate_detail_image)
        }

    }
}

private fun format(available_at: Date?): String? {
    val format = SimpleDateFormat("dd/MM/yyy")
    return format.format(available_at)
}
