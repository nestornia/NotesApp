package com.example.sqlite.persistence.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.sqlite.async.DeleteAsyncTask;
import com.example.sqlite.async.InsertAsyncTask;
import com.example.sqlite.async.UpdateAsyncTask;
import com.example.sqlite.model.Note;
import com.example.sqlite.persistence.NoteDatabase;

import java.util.List;

public class NoteRepository {

    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context) {
        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNote(Note note) {
        new InsertAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }

    public void updateNote(Note note) {
        new UpdateAsyncTask(mNoteDatabase.getNoteDao()).execute(note);

    }

    public LiveData<List<Note>> retrieveNotesTask() {
        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNote(Note note){
        new DeleteAsyncTask(mNoteDatabase.getNoteDao()).execute(note);
    }
}
