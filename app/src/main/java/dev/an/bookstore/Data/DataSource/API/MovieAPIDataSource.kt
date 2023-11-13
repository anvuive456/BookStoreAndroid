package dev.an.bookstore.Data.DataSource.API

import dev.an.bookstore.Data.DataSource.API.Entity.MovieAPIEntity
import dev.an.bookstore.Data.DataSource.API.Entity.toMovie
import dev.an.bookstore.Data.DataSource.Base.MovieDataSource
import dev.an.bookstore.Domain.Model.Movie
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface MovieApi {
  @GET()
  suspend fun getMovies(): List<MovieAPIEntity>

  @DELETE()
  suspend fun deleteMovie(id: Int)

  @POST()
  suspend fun addMovie(movie: Movie): Movie

  companion object {
    var movieApi: MovieApi? = null
    fun getInstance(): MovieApi {
      if (movieApi == null) {
        movieApi = Retrofit.Builder()
          .baseUrl("http://localhost:8080")
          .addConverterFactory(GsonConverterFactory.create())
          .build().create(MovieApi::class.java)
      }
      return movieApi!!
    }
  }
}

class MovieAPIDataSource : MovieDataSource {
  override suspend fun getMovies(): List<Movie> =
    MovieApi.getInstance().getMovies().map { it.toMovie() }

  override suspend fun deleteMovie(id: Int) = MovieApi.getInstance().deleteMovie(id)

  override suspend fun addMovie(movie: Movie): Movie = MovieApi.getInstance().addMovie(movie)
}