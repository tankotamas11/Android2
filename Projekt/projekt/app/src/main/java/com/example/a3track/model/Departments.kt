package com.example.a3track.model
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Departments(
    var ID:Int,
    var name:String
)
