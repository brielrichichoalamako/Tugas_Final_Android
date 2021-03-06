package com.briel.tugas_final.UI.Detail

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.briel.tugas_final.Model.Standing
import com.briel.tugas_final.Model.Stat
import com.briel.tugas_final.R
import com.briel.tugas_final.adapter.StatsAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_layout_home_team.view.*

class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailToolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        title.text = standing!!.team.displayName

        Picasso.get()
            .load(standing!!.team.logos[0].href)
            .into(logoTeamDetail)

        if(standing!!.note != null) {
            championLayout.visibility = View.VISIBLE
            titleChamp.text = standing!!.note!!.description
            rankChamp.text = "Ranks ${standing!!.note!!.rank}"
        }

        initReciclerView()
    }

    private fun initReciclerView() {
        rcView_stats.setHasFixedSize(true)
        rcView_stats.layoutManager = GridLayoutManager(this.requireContext(), 2)
        rcView_stats.adapter = StatsAdapter(standing!!.stats as MutableList<Stat>, object : StatsAdapter.Listener {
            override fun onShareClick(stat: Stat) {
                shareAction(stat)
            }
        })
    }

    private fun shareAction(stat: Stat) {

        val text = "${standing!!.team.displayName}\n" +
                "${stat.displayName} : ${stat.value}"

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(
                Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    companion object {

        @JvmStatic
        fun newInstance(standingg: Standing) = DetailFragment()
        var standing: Standing? = null
    }
}