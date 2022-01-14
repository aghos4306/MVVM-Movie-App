package com.example.mvvmretrofitrecyclerview.repository

import com.example.mvvmretrofitrecyclerview.api.RetrofitService

class MainRepository constructor(val retrofitService: RetrofitService) {
    fun getAllMovies() = retrofitService.getAllMovies()
}