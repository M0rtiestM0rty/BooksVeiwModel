package com.example.w3_hw_booklibrary.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class BooksViewModel ( private val repository: BooksRepository = BooksRepository()) : ViewModel() {

    private val _books = MutableStateFlow<List<BookItems>>(emptyList())
    val books: StateFlow<List<BookItems>> = _books

    init {
        loadBooks("android")
    }

    private fun loadBooks(query: String) {
        viewModelScope.launch {
            try {
                val result = repository.getBooks(query)
                _books.value = result
            } catch (e: Exception) {
                // handle errors
                _books.value = emptyList()
            }
        }
    }
}
