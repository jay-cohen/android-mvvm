package com.example.cryptomvvmtutorial.presentation.coin_detail

import com.example.cryptomvvmtutorial.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
