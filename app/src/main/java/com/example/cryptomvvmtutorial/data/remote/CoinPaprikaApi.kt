package com.example.cryptomvvmtutorial.data.remote

import com.example.cryptomvvmtutorial.data.dto.CoinDetailDto
import com.example.cryptomvvmtutorial.data.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>


    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

}