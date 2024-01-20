package com.example.recipes

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("recipes")
    fun getRecipiData():Call<MyRecipeData>
}