package com.example.notetakingapp.domain.repository

import com.example.notetakingapp.data.database.NoteDAO
import com.example.notetakingapp.data.database.NoteDatabase
import com.example.notetakingapp.data.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(private val noteDao: NoteDAO) {
    suspend fun addNote(note: Note) = withContext(Dispatchers.IO) { noteDao.insert(note) }
    suspend fun updateNote(note: Note) = withContext(Dispatchers.IO) { noteDao.update(note) }
    suspend fun deleteNote(note: Note) = withContext(Dispatchers.IO) { noteDao.deleteNote(note) }
    suspend fun deleteAllNotes() = withContext(Dispatchers.IO) { noteDao.deleteAll() }
    fun getAllNotes(): Flow<List<Note>> =
        noteDao.getNotes().flowOn(Dispatchers.IO).conflate()
}