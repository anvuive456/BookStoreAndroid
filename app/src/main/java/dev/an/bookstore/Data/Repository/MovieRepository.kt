package dev.an.bookstore.Data.Repository

import dev.an.bookstore.Data.DataSource.Base.MovieDataSource
import dev.an.bookstore.Domain.Model.Movie
import dev.an.bookstore.Domain.RepositoryInterfaces.IMovieRepository

class MovieRepository(private val dataSource: MovieDataSource): IMovieRepository {
  override suspend fun getMovies(): List<Movie> = dataSource.getMovies()
  override suspend fun addMovie(movie: Movie): Movie =dataSource.addMovie(movie)
  override suspend fun deleteMovie(id: Int) = dataSource.deleteMovie(id)
}