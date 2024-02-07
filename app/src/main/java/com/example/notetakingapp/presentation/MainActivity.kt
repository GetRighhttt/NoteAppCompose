package com.example.notetakingapp.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notetakingapp.data.model.Note
import com.example.notetakingapp.presentation.screens.HomeScreen
import com.example.notetakingapp.presentation.viewmodel.NoteTakingViewModel
import com.example.notetakingapp.ui.theme.NoteTakingAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteTakingAppTheme {
                MyApp {
                    val notes = remember { mutableStateListOf<Note>() }
                    val noteViewModel: NoteTakingViewModel by viewModels()
                    NotesApp(noteViewModel = noteViewModel)
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

@Composable
fun NotesApp(noteViewModel: NoteTakingViewModel = viewModel()) {
    val noteList = noteViewModel.noteList.collectAsState().value
    HomeScreen(
        notes = noteList,
        onAddNote = { noteViewModel.addNote(it) },
        onRemoveNote = { noteViewModel.deleteNote(it) })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteTakingAppTheme {

    }
}