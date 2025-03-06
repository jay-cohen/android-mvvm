package com.example.cryptomvvmtutorial.domain.use_case.get_coin

import com.example.cryptomvvmtutorial.common.Resource
import com.example.cryptomvvmtutorial.data.dto.toCoinDetail
import com.example.cryptomvvmtutorial.domain.model.CoinDetail
import com.example.cryptomvvmtutorial.domain.respository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't connect to the internet. Please check your settings."))
        }
    }
}