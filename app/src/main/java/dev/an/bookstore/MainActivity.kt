package dev.an.bookstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.an.bookstore.Data.DataSource.DB.MovieDBDataSource
import dev.an.bookstore.Data.Repository.MovieRepository
import dev.an.bookstore.Presentation.Movie.ListMovies.ListMovieView
import dev.an.bookstore.Presentation.Movie.ListMovies.ListMovieViewModel
import dev.an.bookstore.ui.theme.BookStoreTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val movieViewModel = ListMovieViewModel(
      MovieRepository(
        MovieDBDataSource()
      )
    )
    movieViewModel.getMovies()

    setContent {
      BookStoreTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
         ListMovieView(vm = movieViewModel)
        }
      }
    }
  }
}
