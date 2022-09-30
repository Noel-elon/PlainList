package com.noelon.core_network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponse(
    val info: Info,
    val results: List<Result>
)

@JsonClass(generateAdapter = true)
data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)

@JsonClass(generateAdapter = true)
data class Result(
    val cell: String,
    val dob: Dob,
    val email: String,
    val gender: String,
    val id: Id,
    val location: Location,
    val login: Login,
    val name: Name,
    val nat: String,
    val phone: String,
    val picture: Picture,
    val registered: Registered
)

@JsonClass(generateAdapter = true)
data class Dob(
    val age: Int,
    val date: String
)

@JsonClass(generateAdapter = true)
data class Id(
    val name: String,
    val value: String
)

@JsonClass(generateAdapter = true)
data class Location(
    val city: String,
    val coordinates: Coordinates,
    val country: String,
    val postcode: Int,
    val state: String,
    val street: Street,
    val timezone: Timezone
)

@JsonClass(generateAdapter = true)
data class Login(
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String
)

@JsonClass(generateAdapter = true)
data class Name(
    val first: String,
    val last: String,
    val title: String
)

@JsonClass(generateAdapter = true)
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

@JsonClass(generateAdapter = true)
data class Registered(
    val age: Int,
    val date: String
)

@JsonClass(generateAdapter = true)
data class Coordinates(
    val latitude: String,
    val longitude: String
)

@JsonClass(generateAdapter = true)
data class Street(
    val name: String,
    val number: Int
)

@JsonClass(generateAdapter = true)
data class Timezone(
    val description: String,
    val offset: String
)