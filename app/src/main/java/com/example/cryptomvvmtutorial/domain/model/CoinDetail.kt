package com.example.cryptomvvmtutorial.domain.model

import com.example.cryptomvvmtutorial.data.dto.TeamMember

data class CoinDetail(
    val coinID: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
