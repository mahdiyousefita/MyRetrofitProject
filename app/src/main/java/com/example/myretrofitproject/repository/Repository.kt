package com.example.myretrofitproject.repository

import com.example.myretrofitproject.api.RetrofitInstance
import com.example.myretrofitproject.model.Post

class Repository {
    suspend fun getPost(): Post{
        return RetrofitInstance.api.getPost()
    }
}