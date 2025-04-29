package com.example.w3_hw_booklibrary.model

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.items
import coil.compose.rememberAsyncImagePainter
import com.example.w3_hw_booklibrary.ui.theme.W3HWBookLibraryTheme
import com.example.w3_hw_booklibrary.model.*


class MainActivity : ComponentActivity() {
    private val viewModel: BooksViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            W3HWBookLibraryTheme {
                Surface(
                    modifier = Modifier.Companion.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val books = viewModel.books.collectAsState().value

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(books) { book ->
                            Column(
                                modifier = Modifier.Companion.fillMaxWidth()
                            ) {
                                val imageUrl = book.volumeInfo.imageLinks?.thumbnail?.replace(
                                    "http://",
                                    "https://"
                                )
                                if (imageUrl != null) {
                                    Image(
                                        painter = rememberAsyncImagePainter(imageUrl),
                                        contentDescription = book.volumeInfo.title,
                                        modifier = Modifier.Companion
                                            .height(180.dp)
                                            .fillMaxWidth(),
                                        contentScale = ContentScale.Companion.Crop
                                    )
                                }
                                Text(
                                    text = book.volumeInfo.title,
                                    style = MaterialTheme.typography.bodySmall,
                                    textAlign = TextAlign.Companion.Center,
                                    modifier = Modifier.Companion
                                        .fillMaxWidth()
                                        .padding(4.dp)
                                )

                            }
                        }
                    }
                }
            }
        }
    }
}