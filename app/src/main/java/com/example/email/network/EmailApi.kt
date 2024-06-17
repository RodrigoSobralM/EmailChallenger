package com.example.email.network

import com.example.email.models.Email
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EmailApi {

    @GET("/api/emails")
    fun getEmails(): Call<List<Email>>

    @GET("/api/emails/{id}")
    fun getEmailById(@Path("id") id: Int): Call<Email>
}
