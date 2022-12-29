package com.example.a3track.model
import android.accounts.AuthenticatorDescription
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class TasksResponse (
    var taskId:Int,
    var title:String,
    var description: String,
    var assignedToUserId:Int,
    var priority:Int,
    var dedline:Long,
    var department_id:Int,
    var status:Int ///New, In progress, Done, Blocked
   // var creator_id:Int
        )
