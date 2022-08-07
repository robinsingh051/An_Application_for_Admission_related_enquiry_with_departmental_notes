package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MessageSender {
    @POST("webhook")
    fun sendMessage(@Body message: UserMessage?): Call<List<BotResponse>>
}