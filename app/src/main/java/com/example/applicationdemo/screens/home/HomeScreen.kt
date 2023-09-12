package com.example.applicationdemo.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.applicationdemo.model.Movie
import com.example.applicationdemo.model.getMovies
import com.example.applicationdemo.navigations.MovieScreens
import com.example.applicationdemo.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        Surface(shadowElevation = 5.dp) {
            TopAppBar(title = {
                Text(text = "Movies")
            }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Transparent
            ))
        }
    },) {
        Box(modifier = Modifier.padding(0.dp,60.dp,0.dp,0.dp)) {
            MainContent(navController = navController)
        }
    }

}
@Composable
fun MainContent(navController: NavController,
    movieList: List<Movie> = getMovies()){
    Column (modifier = Modifier.padding(12.dp)){
        LazyColumn{
            items(items = movieList){
                MovieRow(movie = it){ movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                    //Log.d("Tag","MainContent: $movie")

                }
            }
        }
    }


}