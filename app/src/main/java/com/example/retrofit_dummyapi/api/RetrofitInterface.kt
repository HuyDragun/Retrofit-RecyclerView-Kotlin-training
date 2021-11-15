package com.example.retrofit_dummyapi.api

import com.example.retrofit_dummyapi.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitInterface {
    @Headers("app-id: 6184be5bc9181d550621dde9")
    @GET("user")
    fun getData(): Call<List<User>>
}