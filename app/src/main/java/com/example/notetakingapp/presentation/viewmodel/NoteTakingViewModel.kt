package com.example.notetakingapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.notetakingapp.data.NoteDataSource
import com.example.notetakingapp.data.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NoteTakingViewModel: ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    private val noteDataSource: NoteDataSource = NoteDataSource()

    init {
        _noteList.value = noteDataSource.loadNotes()
    }
    private operator fun MutableStateFlow<List<Note>>.invoke(note: Note) = _noteList.value.plus(note)
    fun addNote(note: Note) {
        _noteList.value = _noteList(note)
    }
    fun removeNote(note: Note) {
        _noteList.value = _noteList.value.minus(note)
    }
    fun getAllNotes(): List<Note> = _noteList.value
}