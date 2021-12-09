package com.briel.tugas_final.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.briel.tugas_final.Model.Stat
import com.briel.tugas_final.R

class StatsAdapter(private val stats: MutableList<Stat>): RecyclerView.Adapter<StatsAdapter.Holder>() {

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(stat: Stat) {
            with(itemView) {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_detail_stats, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(stats[position])
    }

    override fun getItemCount(): Int {
        return stats.size
    }


}