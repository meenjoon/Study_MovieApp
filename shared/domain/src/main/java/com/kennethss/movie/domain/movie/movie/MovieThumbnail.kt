package com.kennethss.movie.domain.movie.movie


// 도메인 계층의 MovieThumbnail 데이터 모델이다. 도메인 계층의 데이터 모델은 바뀌지 않고 고유하다.
data class MovieThumbnail(
    val id: Int,
    val name: String,
    val posterUrl: String
)
