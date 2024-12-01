package com.bootcamp.ejercicio4app.model


data class News(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article(
    val source: Source,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?
)

data class Source(
    val id: String?,
    val name: String
)