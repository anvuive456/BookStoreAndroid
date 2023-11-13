package dev.an.bookstore.Data.DataSource.Base

import dev.an.bookstore.Domain.Model.Movie

interface MovieDataSource {
  suspend fun getMovies(): List<Movie>
  suspend fun deleteMovie(id: Int)
  suspend fun addMovie(movie: Movie): Movie
}