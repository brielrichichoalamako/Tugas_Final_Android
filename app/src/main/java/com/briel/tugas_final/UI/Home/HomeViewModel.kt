package com.briel.tugas_final.UI.Home

import android.util.Log
import androidx.lifecycle.ViewModel
import com.briel.tugas_final.Model.Data
import com.briel.tugas_final.Model.Standing
import com.briel.tugas_final.Model.Team
import com.briel.tugas_final.Network.RetrofitClient
import com.briel.tugas_final.adapter.TeamAdapter
import retrofit2.Response
import java.lang.Exception

class HomeViewModel: ViewModel() {
    private val TAG = "HomeViewModel"
    var listStanding = mutableListOf<Standing>()

    suspend fun getTeamStandingData(adapter: TeamAdapter) {
        val response = RetrofitClient.instance.getTeamStanding()
        if(response.isSuccessful) {
            listStanding = response.body()?.data?.standings as MutableList<Standing>
            adapter.setData(listStanding)
        } else {
            Log.e(TAG, "getTeamStandingData Response Failed, Response Code: ${response.code()}")
        }
    }

}