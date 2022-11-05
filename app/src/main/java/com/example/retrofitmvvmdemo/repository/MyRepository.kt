package com.example.retrofitmvvmdemo.repository

import com.example.retrofitmvvmdemo.models.UserResponseModel
import com.example.retrofitmvvmdemo.network.ApiService

class MyRepository(private val apiService : ApiService) {

    suspend fun getUsers(pageNumber : Int) : UserResponseModel {
        return apiService.getUsers(pageNumber)
    }
}