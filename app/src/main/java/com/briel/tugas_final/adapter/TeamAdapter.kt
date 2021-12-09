package com.briel.tugas_final.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.briel.tugas_final.Model.Standing
import com.briel.tugas_final.Model.Team
import com.briel.tugas_final.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout_home_team.view.*

class TeamAdapter(val listener: TeamAdapter.Listener): RecyclerView.Adapter<TeamAdapter.Holder>() {

    interface Listener {
        fun onItemCLick(standing: Standing)
    }

    private var listStanding = mutableListOf<Standing>()

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(tim: Standing, listener: Listener) {
            with(itemView) {
                Picasso.get()
                    .load(tim.team.logos[0].href)
                    .into(logoTeam)

                nameTeam.text = tim.team.displayName

                this.setOnClickListener {
                    listener.onItemCLick(tim)
                }
            }
        }
    }

    fun setData(list: MutableList<Standing>) {
        this.listStanding = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_home_team, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: TeamAdapter.Holder, position: Int) {
        holder.bind(listStanding[position], listener)
    }

    override fun getItemCount(): Int {
        return listStanding.size
    }


}