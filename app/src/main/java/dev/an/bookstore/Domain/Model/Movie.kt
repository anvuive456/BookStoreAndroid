package dev.an.bookstore.Domain.Model

import java.util.Date

data class Movie(
  val id: String,
  val title: String,
  val publishedAt: Date,
  val author: Author
)
