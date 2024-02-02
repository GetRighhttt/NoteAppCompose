package com.example.notetakingapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.notetakingapp.presentation.widgets.BottomAppBarAbstraction
import com.example.notetakingapp.presentation.widgets.FloatingActionButtonAbstraction
import com.example.notetakingapp.presentation.widgets.TopAppBarAbstraction

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
//    noteTakingViewModel: NoteTakingViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            TopAppBarAbstraction()
        },
        bottomBar = {
            BottomAppBarAbstraction(modifier = Modifier.fillMaxWidth())
        },
        floatingActionButton = {
            FloatingActionButtonAbstraction()
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Home Screen",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}