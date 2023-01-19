package com.kennethss.movie.domain.movie.movie

import com.kennethss.movie.domain.movie.actor.Actor
import com.kennethss.movie.domain.movie.director.Director
import com.kennethss.movie.domain.movie.preview.Preview
import java.time.LocalDate


// 도메인 계층의 Movie 데이터 모델이다. 도메인 계층의 데이터 모델은 바뀌지 않고 고유하다.
data class Movie(
    val id: Int,
    val title: String,
    val rating: Float,
    val overview: String,
    val runtime: Int,
    val posterUrl: String,
    val releaseDate: String,
    val actors: List<Actor>,
    val directors: List<Director>,
    val previews: List<Preview>
)

fun Movie.directorsText() = directors.joinToString { director -> director.name + "," }
fun Movie.actorsText() = actors.joinToString { actor -> actor.name + "," }
fun Movie.rating() = String.format("%.1f", rating)
fun Movie.releaseYear() = LocalDate.parse(releaseDate).year.toString()
