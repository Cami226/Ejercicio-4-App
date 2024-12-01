package com.bootcamp.ejercicio4app.data


import com.bootcamp.ejercicio4app.model.News
import com.bootcamp.ejercicio4app.util.Constants
import com.bootcamp.ejercicio4app.util.Constants.Companion.API_KEY
import com.bootcamp.ejercicio4app.util.Constants.Companion.ENDPOINT

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AppiNews {
    @GET(ENDPOINT)
    suspend fun getNews(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<News>
}