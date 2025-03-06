package com.example.cryptomvvmtutorial.domain.use_case.get_coins

import com.example.cryptomvvmtutorial.common.Resource
import com.example.cryptomvvmtutorial.data.dto.toCoin
import com.example.cryptomvvmtutorial.domain.model.Coin
import com.example.cryptomvvmtutorial.domain.respository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't connect to the internet. Please check your settings."))
        }
    }
}