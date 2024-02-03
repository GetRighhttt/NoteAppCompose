package com.example.notetakingapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notetakingapp.data.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDAO
}