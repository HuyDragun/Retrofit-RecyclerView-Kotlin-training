package com.example.retrofit_dummyapi.model

import com.example.retrofit_dummyapi.api.RetrofitInterface
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository{

    private val baseUrl = "https://dummyapi.io/data/v1/"

    fun getUser() : Call<List<User>> {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

        val retrofitData = retrofit.create(RetrofitInterface::class.java)
        return retrofitData.getData()
    }
}