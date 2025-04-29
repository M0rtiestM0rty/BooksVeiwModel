package com.example.w3_hw_booklibrary.model

data class BooksResponse(
    val items : List< BookItems>?
    )

data class BookItems(
    val id: String,
    val volumeInfo: VolumeInfo
    )

data class VolumeInfo(
    val title: String,
    val authors: List<String>?,
    val imageLinks: ImageLinks?
    )

data class ImageLinks(
    val thumbnail: String
    )
