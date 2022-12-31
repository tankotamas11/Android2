package com.example.a3track.model

data class Task(
                 var title:String,
                 var description: String,
                 var created_time:Long,
                 var created_by_user_ID:Int,
                 var asigned_to_user_ID:Int,
                 var priority:Int,
                 var deadline:Long,
                 var status:Int,
                 var progress:Int)
