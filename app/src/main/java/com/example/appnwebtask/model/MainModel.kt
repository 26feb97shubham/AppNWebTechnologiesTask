package com.example.appnwebtask.model


import com.google.gson.annotations.SerializedName

data class MainModel(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: String
)