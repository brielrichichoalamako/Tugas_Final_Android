package com.briel.tugas_final.Model

data class Data(
    val abbreviation: String,
    val name: String,
    val season: Int,
    val seasonDisplay: String,
    val standings: List<Standing>
)