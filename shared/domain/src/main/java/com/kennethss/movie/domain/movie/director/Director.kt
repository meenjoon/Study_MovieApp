package com.kennethss.movie.domain.movie.director

// 도메인 계층의 Director 데이터 모델이다. 도메인 계층의 데이터 모델은 바뀌지 않고 고유하다.
data class Director(
    val id: Int,
    val name: String,
    val profileUrl: String
)
