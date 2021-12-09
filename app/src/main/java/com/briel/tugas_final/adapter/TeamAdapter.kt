package com.briel.tugas_final.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.briel.tugas_final.Model.Team
import com.briel.tugas_final.R
import com.briel.tugas_final.UI.Home.Tim
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout_home_team.view.*

class TeamAdapter(): RecyclerView.Adapter<TeamAdapter.Holder>() {

    private var listTeam = mutableListOf<Tim>()

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tim: Tim) {
            with(itemView) {
                Picasso.get()
                    .load(tim.url)
                    .into(logoTeam)
                nameTeam.text = tim.name
            }
        }
    }

    fun setData(list: MutableList<Tim>) {
        this.listTeam = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_home_team, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: TeamAdapter.Holder, position: Int) {
        holder.bind(listTeam[position])
    }

    override fun getItemCount(): Int {
        return listTeam.size
    }


}