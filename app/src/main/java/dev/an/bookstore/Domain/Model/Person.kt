package dev.an.bookstore.Domain.Model

import java.util.Date

abstract class Person(
  var name: String,
  var birthDay: Date,
)

data class Author(
  val movies: ArrayList<Movie>,
  val birthDay: Date,
  val name: String,
)
