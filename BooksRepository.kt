package com.example.w3_hw_booklibrary.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BooksRepository{
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/books/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val booksApiService = retrofit.create(BooksApiService:: class.java)

    suspend fun getBooks (query: String): List<BookItems>{
        val response = booksApiService.searchBooks(query)
        return response.items ?: emptyList()
    }// end suspend function
}// end class