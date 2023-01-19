package com.kennethss.movie.data.actor

import com.kennethss.movie.domain.movie.actor.Actor


//데이터 계층에서의 ActorData 대한 데이터 모델이다.  데이터를 받아올 때 쓰고 고유하지 않다. 고유한 것은 domain 계층의 Actor 데이터 모델이다.
data class ActorData(
    val id: Int,
    val name: String,
    val profileUrl: String,
    val character: String
)

fun ActorData.toDomain() = Actor(
    id = id,
    name = name,
    profileUrl = profileUrl,
    character = character,

)
