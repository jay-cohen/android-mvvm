package com.example.cryptomvvmtutorial.data.repository

import com.example.cryptomvvmtutorial.data.dto.CoinDetailDto
import com.example.cryptomvvmtutorial.data.dto.CoinDto
import com.example.cryptomvvmtutorial.data.remote.CoinPaprikaApi
import com.example.cryptomvvmtutorial.domain.respository.CoinRepository
import javax.inject.Inject


class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}