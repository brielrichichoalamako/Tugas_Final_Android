package com.briel.tugas_final.UI.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.briel.tugas_final.Model.Data
import com.briel.tugas_final.Model.Standing
import com.briel.tugas_final.Model.Team
import com.briel.tugas_final.R
import com.briel.tugas_final.UI.Detail.DetailFragment
import com.briel.tugas_final.adapter.TeamAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var adapter: TeamAdapter
    private lateinit var viewModel: HomeViewModel
    var listStanding = mutableListOf<Standing>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariable()
        initListener()

        lifecycleScope.launch {
            viewModel.getTeamStandingData(adapter)
        }
    }

    private fun initVariable() {
        viewModel = HomeViewModel()
        adapter = TeamAdapter(object : TeamAdapter.Listener {
            override fun onItemCLick(standing: Standing) {
                DetailFragment.standing = standing
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
            }
        })
        rcView_home.setHasFixedSize(true)
        rcView_home.layoutManager = GridLayoutManager(this.requireContext(), 2)
        rcView_home.adapter = adapter

    }

    private fun initListener() {

    }


    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}
