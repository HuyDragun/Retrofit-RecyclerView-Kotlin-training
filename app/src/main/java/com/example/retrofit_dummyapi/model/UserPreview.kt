package com.example.retrofit_dummyapi.model

import com.google.gson.annotations.SerializedName

data class UserPreview(
    @SerializedName("data")
    val `data`: List<User>,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total")
    val total: Int
)