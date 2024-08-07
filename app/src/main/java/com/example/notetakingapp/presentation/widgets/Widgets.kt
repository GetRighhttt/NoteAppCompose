package com.example.notetakingapp.presentation.widgets

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notetakingapp.R
import com.example.notetakingapp.presentation.viewmodel.NoteTakingViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarAbstraction(modifier: Modifier = Modifier) {

    val openDialog = remember { mutableStateOf(false) }
    val openLeftDialog = remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        colors =
        TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground
        ),
        title = {
            Text(
                text = stringResource(R.string.note_taking_app),
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { openDialog.value = true }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(R.string.menu)
                )
            }
        },
        actions = {
            IconButton(onClick = { openLeftDialog.value = true }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add)
                )
            }
        },
        modifier = modifier.fillMaxWidth()
    )
    if (openDialog.value) {
        AlertDialog(onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Navigation Icon") },
            text = { Text(text = "Default navigation...") },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            })
    }
    if (openLeftDialog.value) {
        AlertDialog(onDismissRequest = { openLeftDialog.value = false },
            title = { Text(text = "Add Icon") },
            text = { Text(text = "Add New Material!") },
            confirmButton = {
                TextButton(
                    onClick = {
                        openLeftDialog.value = false
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openLeftDialog.value = false
                    }
                ) {
                    Text("Dismiss")
                }
            })
    }
}

@Composable
fun BottomAppBarAbstraction(
    modifier: Modifier = Modifier,
    noteViewModel: NoteTakingViewModel = viewModel()
) {
    val context = LocalContext.current

    BottomAppBar(
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = stringResource(R.string.home)
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show()

            }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = stringResource(R.string.share)
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show()

            }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = stringResource(R.string.settings)
                )
            }
            IconButton(onClick = {
                Toast.makeText(context, "List", Toast.LENGTH_SHORT).show()

            }) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = stringResource(R.string.list)
                )
            }
            IconButton(onClick = {
                noteViewModel.deleteAllNotes()
                Toast.makeText(context, "Deleted All Notes", Toast.LENGTH_SHORT).show()

            }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = stringResource(R.string.delete)
                )
            }
        }, floatingActionButton = { FloatingActionButtonAbstraction() }
    )
}

@Composable
fun FloatingActionButtonAbstraction(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    FloatingActionButton(
        onClick = {
            Toast.makeText(context, "Favorites", Toast.LENGTH_SHORT).show()

        },
        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = stringResource(R.string.favorite)
        )
    }
}