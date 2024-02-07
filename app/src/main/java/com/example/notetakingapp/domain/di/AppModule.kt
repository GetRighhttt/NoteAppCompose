package com.example.notetakingapp.domain.di

import android.content.Context
import androidx.room.Room
import com.example.notetakingapp.data.database.NoteDAO
import com.example.notetakingapp.data.database.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDAO = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "notes_db"
        )
            .fallbackToDestructiveMigration()
            .build()
}