package com.pr7.kotlin_flow_with_retrofit_mvvm.model.network

import com.pr7.kotlin_flow_with_retrofit_mvvm.model.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    fun getapi():Api{
        val retrofit= Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api=retrofit.create(Api::class.java)
        return api
    }

}