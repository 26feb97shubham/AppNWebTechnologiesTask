package com.example.appnwebtask.apiclient

import com.example.appnwebtask.apiinterface.APIInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIClient {
    private val BASE_URL : String = "http://dummy.restapiexample.com/api/v1/"
    private var retrofit : Retrofit? = null

    val APIClient : APIInterface
    get() {
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(APIInterface::class.java)
    }
}