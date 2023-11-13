package dev.an.bookstore.Data.DataSource.DB

import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import dev.an.bookstore.Data.DataSource.Base.MovieDataSource
import dev.an.bookstore.Domain.Model.Author
import dev.an.bookstore.Domain.Model.Movie
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import java.util.Date

class MovieDBDataSource() : MovieDataSource {

  private var _movies = mutableListOf<Movie>(
    Movie(
      "1",
      "Avenger",
      Date(),
      author = Author(movies = arrayListOf(), birthDay = Date(), name = "JAck kipber"),
    ),
    Movie(
      "2",
      "Interstella",
      Date(),
      author = Author(movies = arrayListOf(), birthDay = Date(), name = "JAck kipber"),
    ),
    Movie(
      "3",
      "Chiken down",
      Date(),
      author = Author(movies = arrayListOf(), birthDay = Date(), name = "JAck kipber"),
    ),
  )

  override suspend fun getMovies(): List<Movie> {
    return _movies
  }

  override suspend fun deleteMovie(id: Int) {
    _movies.removeIf { it.id == id.toString() }
  }

  override suspend fun addMovie(movie: Movie): Movie {
    _movies.add(movie)
    return movie
  }
}