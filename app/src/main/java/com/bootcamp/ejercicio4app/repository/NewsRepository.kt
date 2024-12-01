package com.bootcamp.ejercicio4app.repository


import com.bootcamp.ejercicio4app.model.News
import com.bootcamp.ejercicio4app.data.ApiNews
import com.bootcamp.ejercicio4app.model.Article
import retrofit2.Response
import javax.inject.Inject

class NewsRepository  @Inject constructor(private val apiNews: ApiNews) {
        suspend fun getNews(query: String): Response<News> {
            return apiNews.getNews(query)
        }

        suspend fun getNewsById(title: String, query: String): Article? {
            val response = apiNews.getNews(query)
            if (response.isSuccessful) {
                return response.body()?.articles?.find { it.title == title }
            }
            return null
        }

    }
