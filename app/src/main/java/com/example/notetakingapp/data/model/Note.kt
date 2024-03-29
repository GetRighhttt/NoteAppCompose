package com.example.notetakingapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes_table")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(), // creates random universal unique IDs

    @ColumnInfo(name = "Note_title")
    val title: String,

    @ColumnInfo(name = "note_entry")
    val entry: String,

    @ColumnInfo(name = "entry_date")
    val entryDate: Date = Date.from(Instant.now())
) // sets the time for each object

