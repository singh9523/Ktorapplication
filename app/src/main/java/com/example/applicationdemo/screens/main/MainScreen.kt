package com.example.applicationdemo.screens.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()){
    Text(text = "Main Screen")
}