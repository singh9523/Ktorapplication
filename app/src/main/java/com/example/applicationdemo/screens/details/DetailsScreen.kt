package com.example.applicationdemo.screens.details

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.applicationdemo.model.Movie
import com.example.applicationdemo.model.getMovies
import com.example.applicationdemo.widgets.MovieRow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, movieId: String?){
    val newmovieList = getMovies().filter { movie ->
        movie.id == movieId
    }
    Scaffold (topBar = {
        Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Arrow Back" ,
                modifier = Modifier.clickable { navController.popBackStack() })
            Spacer(modifier = Modifier.width(100.dp))
            TopAppBar(title = {
                Text(text = "Movie")
            }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Transparent
            ))
        }
    }){
        //Spacer(modifier = Modifier.width(400.dp))
        Surface (modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            MovieRow(movie = newmovieList.first())
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Text(text = "Movie Images")
            HorizontalScrollableImageView(newmovieList)
           }
    }}}

@Composable
private fun HorizontalScrollableImageView(newmovieList: List<Movie>) {
    LazyRow {
        items(newmovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
            ) {
                AsyncImage(model = image, contentDescription = "Movie Pster")
            }
        }
    }
}
