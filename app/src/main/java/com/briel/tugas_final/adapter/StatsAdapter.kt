package com.briel.tugas_final.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.briel.tugas_final.Model.Stat
import com.briel.tugas_final.R
import kotlinx.android.synthetic.main.item_layout_detail_stats.view.*

class StatsAdapter(private val stats: MutableList<Stat>, private val listener: Listener): RecyclerView.Adapter<StatsAdapter.Holder>() {

    interface Listener {
        fun onShareClick(stat: Stat)
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(stat: Stat, listener: Listener) {
            with(itemView) {
                displayName.text = stat.displayName
                count.text = stat.value.toString()
                shareBtn.setOnClickListener {
                    listener.onShareClick(stat)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_detail_stats, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(stats[position], listener)
    }

    override fun getItemCount(): Int {
        return stats.size
    }


}