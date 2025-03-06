package com.example.cryptomvvmtutorial.domain.respository

import com.example.cryptomvvmtutorial.data.dto.CoinDetailDto
import com.example.cryptomvvmtutorial.data.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}