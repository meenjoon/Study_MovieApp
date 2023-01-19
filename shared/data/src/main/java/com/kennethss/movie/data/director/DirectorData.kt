package com.kennethss.movie.data.director

import com.kennethss.movie.domain.movie.director.Director

//데이터 계층에서의 DirectorData 대한 데이터 모델이다.  데이터를 받아올 때 쓰고 고유하지 않다. 고유한 것은 domain 계층의 Director 데이터 모델이다.
data class DirectorData(
    val id: Int,
    val name: String,
    val profileUrl: String
)

fun DirectorData.toDomain() = Director(
    id = id,
    name = name,
    profileUrl = profileUrl
)
