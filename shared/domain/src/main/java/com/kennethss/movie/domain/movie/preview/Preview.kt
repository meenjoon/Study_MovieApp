package com.kennethss.movie.domain.movie.preview


// 음이다. 도메인 계층의 데이터 모델은 바뀌지 않고 고유하다.

data class Preview(
    val key: String,
    val name: String,
    val site: Site,
    val type: Type
) {
    enum class Type {
        TRAILER,
        TEASER,
        FEATURETTE
    }

    enum class Site {
        YOUTUBE
    }
}
