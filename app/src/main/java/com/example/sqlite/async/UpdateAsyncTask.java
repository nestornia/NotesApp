package com.example.sqlite.async;

import android.os.AsyncTask;
import android.util.Log;

import com.example.sqlite.model.Note;
import com.example.sqlite.persistence.NoteDao;

public class UpdateAsyncTask extends AsyncTask<Note, Void, Void>{

    private static final String TAG = "InsertAsyncTask";

    private NoteDao mNoteDao;
    public UpdateAsyncTask(NoteDao dao) {
        this.mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.update(notes);
        return null;
    }
}