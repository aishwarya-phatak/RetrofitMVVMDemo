package com.example.retrofitmvvmdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitmvvmdemo.databinding.UsersFragmentBinding
import com.example.retrofitmvvmdemo.models.User
import com.example.retrofitmvvmdemo.network.ApiService
import com.example.retrofitmvvmdemo.repository.MyRepository
import com.example.retrofitmvvmdemo.viewmodels.UserViewModel
import com.example.retrofitmvvmdemo.viewmodels.factory.ViewModelFactory

class UsersFragment : Fragment() {
    lateinit var userViewModel : UserViewModel
    lateinit var binding: UsersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UsersFragmentBinding.inflate(inflater)
        initViewModel()
        userViewModel.getUsers()
        return binding.root
    }

    private fun initViewModel(){
        userViewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                MyRepository(
                    ApiService.getInstance()
                )
            )
        ).get(UserViewModel::class.java)
    }
}