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
import kotlinx.android.synthetic.main.professional_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*

class CandidateAdapter (val candidate: Candidate) : AbstractItem<CandidateAdapter, CandidateAdapter.CandidateViewHolder>() {
     override fun getType(): Int {
         return R.id.professional_item_date
     }

    override fun getViewHolder(v: View?): CandidateViewHolder {
        return CandidateViewHolder(v)
    }

    override fun getLayoutRes(): Int {
        return R.layout.professional_list_item
    }

    class CandidateViewHolder(itemView: View?) : FastAdapter.ViewHolder<CandidateAdapter>(itemView) {
        override fun unbindView(item: CandidateAdapter?) {
            itemView.professional_item_name.text = null
            itemView.professional_item_exp.text = null
            itemView.professional_item_date.text = null
            itemView.professional_item_name.text = null
            itemView.professional_item_job.text = null
        }

        @RequiresApi(Build.VERSION_CODES.O)
        override fun bindView(item: CandidateAdapter?, payloads: MutableList<Any>?) {
            val candidate = item?.candidate
            itemView.professional_item_name.text = candidate?.firstname
            itemView.professional_item_exp.text = candidate?.year_exp.toString() + " années d'expériences"
            itemView.professional_item_date.text = format(candidate?.available_at)
            itemView.professional_item_job.text = candidate?.job_id.toString()
            Picasso.get().load(candidate?.profile_picture_url).circle().into(itemView.professional_item_img)
        }

    }
}

private fun format(available_at: Date?): String? {
    val format = SimpleDateFormat("dd/MM/yyy")
    return format.format(available_at)
}
