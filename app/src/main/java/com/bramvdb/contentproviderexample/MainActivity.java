package com.bramvdb.contentproviderexample;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.bramvdb.opensource.omninotesmodels.Note;

import org.json.JSONException;

import java.util.Timer;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver cr = getContentResolver();
        Cursor notes = cr.query(Uri.parse("content://it.feio.android.Notes/all"),null,null,null,null);

        Context mContext = this;
        while(notes.moveToNext()){
            Note note = Note.parse(notes);
            Toast.makeText(this,note.title+": "+note.content,Toast.LENGTH_SHORT).show();
            Toast.makeText(this,note.category.getName(),Toast.LENGTH_SHORT).show();
            try {
                Toast.makeText(mContext,note.toJSON(),Toast.LENGTH_SHORT).show();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
