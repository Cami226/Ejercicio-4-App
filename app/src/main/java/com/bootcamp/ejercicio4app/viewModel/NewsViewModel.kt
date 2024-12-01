package com.bootcamp.ejercicio4app.viewModel


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bootcamp.ejercicio4app.model.Article
import com.bootcamp.ejercicio4app.model.News
import com.bootcamp.ejercicio4app.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    private val _news = MutableStateFlow<List<Article>>(emptyList())
    val news = _news.asStateFlow()

    private var query = "dog"


    init {
        fetchAllNews(query)
    }

    private fun fetchAllNews(query: String) {
        viewModelScope.launch {
            val response = repository.getNews(query)
            if (response.isSuccessful) {
                _news.value = response.body()?.articles ?: emptyList()
            } else {
                Log.e("NewsViewModel", "Error: ${response.errorBody()}")
            }
        }
    }
    // Segunda función: Obtener una noticia por id o name
    fun getArticleByTitle(title: String): StateFlow<Article?> {
        val result = MutableStateFlow<Article?>(null)
        viewModelScope.launch {
            val article = _news.value.find { it.title == title }
            result.value = article
        }
        return result
    }
    }
