package com.kennethss.movie.remote.response.detail


import com.kennethss.movie.data.actor.ActorData
import com.kennethss.movie.remote.response.popular.IMAGE_BASE_HOST
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// @Serialized와 @SerialName을 이용해서 원하는 키와 매핑하는 데이터모델 클래스이다.
@Serializable
data class Cast(
    @SerialName("adult")
    val adult: Boolean = false,
    @SerialName("cast_id")
    val castId: Int = 0,
    @SerialName("character")
    val character: String = "",
    @SerialName("credit_id")
    val creditId: String = "",
    @SerialName("gender")
    val gender: Int = 0,
    @SerialName("id")
    val id: Int = 0,
    @SerialName("known_for_department")
    val knownForDepartment: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("order")
    val order: Int = 0,
    @SerialName("original_name")
    val originalName: String = "",
    @SerialName("popularity")
    val popularity: Double = 0.0,
    @SerialName("profile_path")
    val profilePath: String = ""
)

fun Cast.toActorData() = ActorData(
    id = id,
    name = name,
    profileUrl = IMAGE_BASE_HOST + profilePath,
    character = character
)
