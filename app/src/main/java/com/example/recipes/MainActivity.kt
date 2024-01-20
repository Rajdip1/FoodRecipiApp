package com.example.recipes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.myRecyclerView)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getRecipiData()

        retrofitData.enqueue(object : Callback<MyRecipeData?> {
            override fun onResponse(call: Call<MyRecipeData?>, response: Response<MyRecipeData?>) {
                val responseBody = response.body()
                val recipiList = responseBody?.recipes!!

                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                myAdapter = MyAdapter(this@MainActivity,recipiList)

                recyclerView.adapter = myAdapter
            }

            override fun onFailure(call: Call<MyRecipeData?>, t: Throwable) {
                Log.d("Main Activity", "onFailure: "+t.message)
            }
        })


    }
}

