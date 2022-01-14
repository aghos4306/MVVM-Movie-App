package com.example.mvvmretrofitrecyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmretrofitrecyclerview.model.MovieModel
import com.example.mvvmretrofitrecyclerview.repository.MainRepository
import retrofit2.Call
import retrofit2.Response

class MainViewModel constructor(val repository: MainRepository) : ViewModel() {

    val movieList = MutableLiveData<List<MovieModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMovies() {

        val response = repository.getAllMovies()
        response.enqueue(object : retrofit2.Callback<List<MovieModel>> {
            override fun onResponse(call: Call<List<MovieModel>>, response: Response<List<MovieModel>>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}