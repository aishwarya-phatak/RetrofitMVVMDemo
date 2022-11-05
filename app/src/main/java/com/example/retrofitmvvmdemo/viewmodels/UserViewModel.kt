package com.example.retrofitmvvmdemo.viewmodels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitmvvmdemo.models.User
import com.example.retrofitmvvmdemo.repository.MyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel (private val myRepository: MyRepository) : ViewModel(){
        private var pageNumber = 0
        var usersList = ArrayList<User>()
        var usersAvailableLiveData = MutableLiveData<Boolean>()

        fun getUsers(){
                CoroutineScope(Dispatchers.IO).launch {
                        var userResponseModel = myRepository.getUsers(++pageNumber)
                        mt("${userResponseModel}")
                        withContext(Dispatchers.Main){
                                usersAvailableLiveData.postValue(true)
                        }
                }
        }

        private fun mt(text : String){
                Log.e("tag",text)
        }
}