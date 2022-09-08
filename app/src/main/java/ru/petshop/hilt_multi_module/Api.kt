package ru.petshop.hilt_multi_module

import com.example.arch_practices.model.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.petshop.hilt_multi_module.model.Coin


interface Api {
    @GET("assets")
    suspend fun getCoins(@Query("offset") offset: Int): Response<Coin>
}