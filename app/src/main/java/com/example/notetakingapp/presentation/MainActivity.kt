package com.example.notetakingapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.notetakingapp.data.NoteDataSource
import com.example.notetakingapp.data.model.Note
import com.example.notetakingapp.presentation.screens.HomeScreen
import com.example.notetakingapp.ui.theme.NoteTakingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteTakingAppTheme {
                MyApp {
                    HomeScreen(
                        notes = NoteDataSource().loadNotes(),
                        onAddNote = {},
                        onRemoveNote = {})
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    NoteTakingAppTheme {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteTakingAppTheme {

    }
}