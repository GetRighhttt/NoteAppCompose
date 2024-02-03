package com.example.notetakingapp.presentation.viewmodel

import android.util.Log
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
class NoteTakingViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    private val noteDataSource: NoteDataSource = NoteDataSource()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged()
                .collect { listOfNotes ->
                    if (listOfNotes.isEmpty()) {
                        Log.d("Empty", ": Empty list")
                    }else {
                        _noteList.value = listOfNotes
                    }

                }

        }
        // noteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
    fun insertNote(note: Note) = viewModelScope.launch { repository.updateNote(note)}
    fun deleteNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }
   fun deleteAllNotes() = viewModelScope.launch { repository.deleteAllNotes() }

}