package com.example.a3track.model
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfileRequest(
    var lastName:String,
    var firstName:String,
    var location:String,
    var phoneNumber:String,
    var imageUrl:String
)
