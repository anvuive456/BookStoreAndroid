package dev.an.bookstore.Presentation.Movie.ListMovies

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.unit.dp
import dev.an.bookstore.Domain.Model.Author
import dev.an.bookstore.Domain.Model.Movie
import kotlinx.coroutines.awaitAll
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListMovieView(vm: ListMovieViewModel) {
  LaunchedEffect(key1 = Unit, block = {
    Log.d("Init","Get movies")
    vm.getMovies()
  })


  Scaffold(
    topBar = {
      TopAppBar(title = { Text("Movies") },
        actions = {
          IconButton(onClick = {
            vm.addMovie(Movie("5", "New Movie", Date(), Author(arrayListOf(), Date(), "Hello")))
            vm.getMovies()
          }) {
            Icon(
              Icons.Outlined.AddCircle,
              contentDescription = "Add Movie",
              tint = androidx.compose.ui.graphics.Color.Blue,
              modifier = Modifier.size(48.dp)
            )
          }
        }
      )
    },
    content = { i ->
      Column(modifier = Modifier.padding(paddingValues = i)) {
        LazyColumn(Modifier.fillMaxWidth()) {
          items(vm.movies) { movie ->
            Row {
              Row(modifier = Modifier.padding(16.dp)) {
                Checkbox(checked = false, onCheckedChange = null)
                Spacer(Modifier.width(5.dp))
                Text(movie.title,color = androidx.compose.ui.graphics.Color.Blue)
              }
              Divider()
            }
          }
        }
      }
    }
  )
}