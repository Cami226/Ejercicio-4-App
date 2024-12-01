package com.bootcamp.ejercicio4app.repository


import com.bootcamp.ejercicio4app.model.News
import com.bootcamp.ejercicio4app.data.AppiNews
import com.bootcamp.ejercicio4app.model.Article
import com.bootcamp.ejercicio4app.util.Constants.Companion.API_KEY
import retrofit2.Response
import javax.inject.Inject

class NewsRepository  @Inject constructor(private val appiNews: AppiNews) {
        suspend fun getNews(query: String): Response<News> {
            return appiNews.getNews(query)
        }

        suspend fun getNewsById(name: String, query: String): Article? {
            val response = appiNews.getNews(query)
            if (response.isSuccessful) {
                return response.body()?.articles?.find { it.source.name == name }
            }
            return null
        }

    }
