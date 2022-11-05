package com.example.retrofitmvvmdemo.viewmodels.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvmdemo.repository.MyRepository
import com.example.retrofitmvvmdemo.viewmodels.UserViewModel

class ViewModelFactory(val myRepository: MyRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserViewModel::class.java)){
            return UserViewModel(myRepository) as T
        }
        throw UnknownError()
    }
}