package com.example.notetakingapp.data.localdatasource

import com.example.notetakingapp.data.model.Note

class NoteDataSource {
    fun loadNotes(): List<Note> = listOf(
        Note(title = "A good day", entry = "We went on a vacation by the lake"),
        Note(title = "Android Compose", entry = "Working on Android Compose course today"),
        Note(title = "Keep at it...", entry = "Sometimes things just happen"),
        Note(title = "A movie day", entry = "Watching a movie with family today"),
        Note(title = "A spa day", entry = "Spa day with family today"),
        Note(title = "A basketball day", entry = "Basketball with family today"),
        Note(title = "A movie day", entry = "Watching a movie with family today"),
        Note(title = "A movie day", entry = "Watching a movie with family today"),
        Note(title = "A movie day", entry = "Watching a movie with family today"),
        Note(title = "A movie day", entry = "Watching a movie with family")
    )
}