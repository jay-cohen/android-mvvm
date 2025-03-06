package com.example.cryptomvvmtutorial.presentation.coin_list

import com.example.cryptomvvmtutorial.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
