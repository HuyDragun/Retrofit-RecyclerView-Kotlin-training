package com.example.retrofit_dummyapi.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("fistName")
    val firstName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("title")
    val title: String
)