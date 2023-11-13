package dev.an.bookstore.Presentation.Movie.ListMovies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.an.bookstore.Domain.Model.Movie
import dev.an.bookstore.Domain.RepositoryInterfaces.IMovieRepository
import kotlinx.coroutines.launch

class ListMovieViewModel(private val movieRepository: IMovieRepository) : ViewModel() {
  private val _movies = mutableListOf<Movie>()

  val movies: List<Movie> get() = _movies

   fun getMovies() {
    viewModelScope.launch {
      _movies.addAll(movieRepository.getMovies())
    }
  }

   fun addMovie(movie: Movie) {
    viewModelScope.launch {
      _movies.add(movieRepository.addMovie(movie))
    }
  }
}