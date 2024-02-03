package com.example.notetakingapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.notetakingapp.data.localdatasource.NoteDataSource
import com.example.notetakingapp.data.model.Note
import com.example.notetakingapp.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NoteTakingViewModel @Inject constructor(repository: Repository): ViewModel() {
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
}