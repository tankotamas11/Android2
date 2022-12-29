package com.example.a3track.model
import android.accounts.AuthenticatorDescription
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class TasksResponse (
    var ID:Int,
    var title:String,
    var description: String,
    var created_time:Long,
    var created_by_user_ID:Int,
    var asigned_to_user_ID:Int,
    var priority:Int,
    var deadline:Long,
    var department_id:Int,
    var status:Int,
    var progress:Int///New, In progress, Done, Blocked
   // var creator_id:Int
        )
