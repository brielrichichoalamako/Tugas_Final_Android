package com.briel.tugas_final.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.briel.tugas_final.Model.Team
import com.briel.tugas_final.R

class TeamAdapter(): RecyclerView.Adapter<TeamAdapter.Holder>() {

    private val listTeam = mutableListOf<Team>()

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind() {
            with(itemView) {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_home_team, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: TeamAdapter.Holder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return listTeam.size
    }


}