package com.kennethss.movie.domain.movie.actor


// 도메인 계층의 Actor 데이터 모델이다. 도메인 계층의 데이터 모델은 바뀌지 않고 고유하다.
data class Actor(
    val id: Int,
    val name: String,
    val profileUrl: String,
    val character: String
)
