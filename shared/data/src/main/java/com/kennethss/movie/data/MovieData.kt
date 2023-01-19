package com.kennethss.movie.data

import com.kennethss.movie.data.actor.ActorData
import com.kennethss.movie.data.actor.toDomain
import com.kennethss.movie.data.director.DirectorData
import com.kennethss.movie.data.director.toDomain
import com.kennethss.movie.data.preview.PreviewData
import com.kennethss.movie.data.preview.toDomain
import com.kennethss.movie.domain.movie.movie.Movie


//데이터 계층에서의 MovieData 대한 데이터 모델이다.  데이터를 받아올 때 쓰고 고유하지 않다. 고유한 것은 domain 계층의 Movie 데이터 모델이다.
data class MovieData(
    val id: Int,
    val title: String,
    val rating: Float,
    val overview: String,
    val runtime: Int,
    val posterUrl: String,
    val releaseDate: String,
    val actors: List<ActorData>,
    val directors: List<DirectorData>,
    val previews: List<PreviewData>
)

fun MovieData.toDomain() = Movie(
    id = id,
    title = title,
    rating = rating,
    overview = overview,
    runtime = runtime,
    posterUrl = posterUrl,
    releaseDate = releaseDate,
    actors = actors.map { actor -> actor.toDomain() },
    directors = directors.map { director -> director.toDomain() },
    previews = previews.map { preview -> preview.toDomain() },
)
