package com.example.a3track.model


    data class CurrentUser(
        var ID: Int = 0,
        val department_id: Int = 0,
        val email: String = "",
        val first_name: String = "",
        val last_name: String = "",
        val location: String? = null,
        val phone_number: String? = null,
        val type: Int = 0,
        val loginResponse: LoginResponse = LoginResponse(123456,"",420),
        val imageUrl : String = ""
    )

