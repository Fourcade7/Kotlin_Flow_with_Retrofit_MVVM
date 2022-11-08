package com.pr7.kotlin_flow_with_retrofit_mvvm.model.api

import com.pr7.kotlin_flow_with_retrofit_mvvm.model.postmodel.Posts
import retrofit2.http.GET

interface Api {

    @GET("posts")
    suspend fun getdata():List<Posts>

}