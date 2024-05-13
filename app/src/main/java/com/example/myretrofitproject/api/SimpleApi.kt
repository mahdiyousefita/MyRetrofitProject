package com.example.myretrofitproject.api

import com.example.myretrofitproject.model.Post
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Post
}