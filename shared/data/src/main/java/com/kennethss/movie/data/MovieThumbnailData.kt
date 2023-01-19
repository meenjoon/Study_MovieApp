package com.kennethss.movie.data

import com.kennethss.movie.domain.movie.movie.MovieThumbnail

//데이터 계층에서의 MovieThumbnailData 대한 데이터 모델이다.  데이터를 받아올 때 쓰고 고유하지 않다. 고유한 것은 domain 계층의 MovieThumbnail 데이터 모델이다.
data class MovieThumbnailData(
    val id: Int,
    val name: String,
    val posterUrl: String
)

fun MovieThumbnailData.toDomain() = MovieThumbnail(
    id = id,
    name = name,
    posterUrl = posterUrl
)
