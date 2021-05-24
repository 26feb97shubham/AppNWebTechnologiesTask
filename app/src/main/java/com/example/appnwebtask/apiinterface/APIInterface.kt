package com.example.appnwebtask.apiinterface

import com.example.appnwebtask.model.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("employees")
    fun employees() : Call<MainModel>
}