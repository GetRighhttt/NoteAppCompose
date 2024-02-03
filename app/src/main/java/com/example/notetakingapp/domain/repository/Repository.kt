package com.example.notetakingapp.domain.repository

import com.example.notetakingapp.data.database.NoteDatabase
import com.example.notetakingapp.data.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val noteDatabase: NoteDatabase) {
    suspend fun addNote(note: Note) = noteDatabase.noteDao().insert(note)
    suspend fun updateNote(note: Note) = noteDatabase.noteDao().update(note)
    suspend fun deleteNote(note: Note) = noteDatabase.noteDao().deleteNote(note)
    suspend fun deleteAllNotes() = noteDatabase.noteDao().deleteAll()
    fun getAllNotes(): Flow<List<Note>> =
        noteDatabase.noteDao().getNotes().flowOn(Dispatchers.IO).conflate()
}