package com.example.mvvmretrofitrecyclerview.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmretrofitrecyclerview.R
import com.example.mvvmretrofitrecyclerview.api.RetrofitService
import com.example.mvvmretrofitrecyclerview.databinding.ActivityMainBinding
import com.example.mvvmretrofitrecyclerview.repository.MainRepository
import com.example.mvvmretrofitrecyclerview.viewmodel.MainViewModel
import com.example.mvvmretrofitrecyclerview.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,
            //MainViewModelFactory(MainRepository(RetrofitService.retrofitService!!)))
            MainViewModelFactory(MainRepository(retrofitService!!)))
            .get(MainViewModel::class.java)

        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMovieList(it)
        })

        viewModel.errorMessage.observe(this, Observer {

        })
        viewModel.getAllMovies()
    }
}