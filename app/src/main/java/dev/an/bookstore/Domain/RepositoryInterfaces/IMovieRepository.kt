package dev.an.bookstore.Domain.RepositoryInterfaces

import dev.an.bookstore.Domain.Model.Movie

interface  IMovieRepository {
  suspend fun getMovies():List<Movie>
  suspend fun addMovie(movie: Movie): Movie
  suspend fun deleteMovie(id: Int)
}