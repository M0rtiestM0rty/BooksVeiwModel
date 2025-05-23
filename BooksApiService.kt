package com.example.w3_hw_booklibrary.model

import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService{
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query: String
    ): BooksResponse
}