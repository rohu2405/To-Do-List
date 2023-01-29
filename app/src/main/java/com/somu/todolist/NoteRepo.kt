package com.somu.todolist

import android.provider.ContactsContract
import androidx.lifecycle.LiveData

class NoteRepo(private val noteDao: NoteDao) {

    val allNotes:
            LiveData<List<ContactsContract.CommonDataKinds.Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)

    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }



}