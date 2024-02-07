package com.example.notetakingapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notetakingapp.data.localdatasource.NoteDataSource
import com.example.notetakingapp.data.model.Note
import com.example.notetakingapp.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteTakingViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    private val noteDataSource: NoteDataSource = NoteDataSource()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect { listOfNotes ->
                    _noteList.value = listOfNotes
                }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch(Dispatchers.IO) { repository.addNote(note) }
    fun updateNote(note: Note) =
        viewModelScope.launch(Dispatchers.IO) { repository.updateNote(note) }

    fun deleteNote(note: Note) =
        viewModelScope.launch(Dispatchers.IO) { repository.deleteNote(note) }

    fun deleteAllNotes() = viewModelScope.launch(Dispatchers.IO) { repository.deleteAllNotes() }

}