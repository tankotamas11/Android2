package com.example.a3track.model
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

    data class CurrentUser(
    var ID: Int = 0,
    var department_id: Int = 0,
    var email: String = "",
    var first_name: String = "",
    var last_name: String = "",
    var location: String? = null,
    var phone_number: String? = null,
    var type: Int = 0,
    var loginResponse: LoginResponse = LoginResponse(123456,"",420),
    var imageUrl : String = ""
    )

