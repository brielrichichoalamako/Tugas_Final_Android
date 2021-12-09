package com.briel.tugas_final.UI.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.briel.tugas_final.Model.Team
import com.briel.tugas_final.R
import com.briel.tugas_final.adapter.TeamAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var adapter: TeamAdapter
    var listTim = mutableListOf<Team>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariable()
        initListener()
    }

    private fun initVariable() {
        adapter = TeamAdapter()

        rcView_home.setHasFixedSize(true)
        rcView_home.layoutManager = GridLayoutManager(this.requireContext(), 2)
        rcView_home.adapter = adapter

    }

    private fun initListener() {

    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = HomeFragment()
    }
}
