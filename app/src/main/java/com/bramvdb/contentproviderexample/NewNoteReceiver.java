package com.bramvdb.contentproviderexample;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;

import com.bramvdb.opensource.omninotesmodels.Note;

import org.json.JSONException;

/**
 * Created by bramvandenbogaerde on 4/06/15.
 */
public class NewNoteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ContentResolver cr = context.getContentResolver();
        Cursor notes = cr.query(Uri.parse("content://it.feio.android.Notes/all"),null,null,null,null);

        while(notes.moveToNext()){
            Note note = Note.parse(notes);
            Toast.makeText(context, note.title + ": " + note.content, Toast.LENGTH_SHORT).show();
            Toast.makeText(context,note.category.getName(),Toast.LENGTH_SHORT).show();
            try {
                Toast.makeText(context,note.toJSON(),Toast.LENGTH_SHORT).show();
            } catch (IllegalAccessException | JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
