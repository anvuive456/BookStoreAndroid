package dev.an.bookstore.Data.DataSource.API.Entity

import dev.an.bookstore.Domain.Model.Author
import dev.an.bookstore.Domain.Model.Movie
import java.util.Date

class MovieAPIEntity(
  val id: Int,
  val title: String,
  val publishedAt: Date,
  val author: Author
)

fun MovieAPIEntity.toMovie(): Movie {
  return Movie(
    id = id.toString(),
    author = author,
    publishedAt = publishedAt,
    title = title
  )
}