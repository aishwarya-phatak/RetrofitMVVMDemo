package com.example.retrofitmvvmdemo.network

import com.example.retrofitmvvmdemo.models.UserResponseModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users?")
    suspend fun getUsers(
        @Query("page") pageNumber : Int
    ) : UserResponseModel

    companion object{
        var apiService : ApiService? = null

        fun getInstance() : ApiService{
            if (apiService == null){
                var retrofit = Retrofit.Builder()
                    .baseUrl("https://reqres.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                apiService = retrofit!!.create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}