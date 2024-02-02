package com.example.notetakingapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notetakingapp.R
import com.example.notetakingapp.presentation.components.NoteButton
import com.example.notetakingapp.presentation.components.NoteInputText
import com.example.notetakingapp.presentation.widgets.BottomAppBarAbstraction
import com.example.notetakingapp.presentation.widgets.TopAppBarAbstraction

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
//    noteTakingViewModel: NoteTakingViewModel = viewModel()
) {
    var title by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBarAbstraction()
        },
        bottomBar = {
            BottomAppBarAbstraction()
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Main Content
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                NoteInputText(
                    modifier = Modifier.padding(top = 10.dp),
                    text = title,
                    label = stringResource(id = R.string.title),
                    onTextChange = { text ->
                        if (text.all { char ->
                            // setting characters
                                char.isLetter() || char.isWhitespace()
                            }) title = text
                    })

                NoteInputText(
                    modifier = Modifier.padding(top = 10.dp),
                    text = note,
                    label = stringResource(R.string.add_note),
                    onTextChange = { text ->
                        if (text.all { char ->
                            // setting characters
                                char.isLetter() || char.isWhitespace()
                            }) note = text
                    })

                NoteButton(modifier = Modifier.padding(top = 10.dp), text = "Save", onClick = { })

                // spacing
                Spacer(modifier = Modifier.height(25.dp))
                Divider(color = MaterialTheme.colorScheme.onBackground)
                Spacer(modifier = Modifier.height(25.dp))

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}