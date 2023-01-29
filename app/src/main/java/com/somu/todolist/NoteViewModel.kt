package com.somu.todolist

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {
    val allNotes: LiveData<List<Note>>
    private val repo : NoteRepo

    init {
        val dao = NoteDB.getDatabase(application).getNoteDao()
        repo = NoteRepo(dao)
        allNotes = repo.allNotes
    }

    fun deleteNote(note: com.somu.todolist.Note) = viewModelScope.launch(Dispatchers.IO) {
            repo.delete(note)
    }

    fun insertNote(note: com.somu.todolist.Note) = viewModelScope.launch ( Dispatchers.IO) {
        repo.insert(note)
    }


}