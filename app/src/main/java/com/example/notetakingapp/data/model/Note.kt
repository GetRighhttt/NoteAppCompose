package com.example.notetakingapp.data.model

import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: UUID = UUID.randomUUID(), // creates random universal unique IDs
    val title: String,
    val entry: String,
    val entryDate: LocalDateTime = LocalDateTime.now() // sets the time for each object
)
