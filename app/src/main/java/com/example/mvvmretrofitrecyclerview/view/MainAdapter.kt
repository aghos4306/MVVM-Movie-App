package com.example.mvvmretrofitrecyclerview.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmretrofitrecyclerview.databinding.AdapterMovieBinding
import com.example.mvvmretrofitrecyclerview.model.MovieModel

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {

    var movies = mutableListOf<MovieModel>()

    fun setMovieList(movies: List<MovieModel>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.name.text = movie.name
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}