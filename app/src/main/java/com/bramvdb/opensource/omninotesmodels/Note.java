package com.bramvdb.opensource.omninotesmodels;

import android.database.Cursor;

import java.io.Serializable;

/**
 * Created by bramvandenbogaerde on 3/06/15.
 */
public class Note extends JSONStringify{
    public Integer id;
    public Long creation;
    public Long lastModification;
    public String title;
    public String content;
    public String archived;
    public String trashed;
    public String alarm;
    public String latitude;
    public String longitude;
    public String address;
    public String locked;
    public String checklist;
    public Category category;

    public static Note parse(Cursor data){
        Note note = new Note();
        note.id = data.getInt(0);
        note.creation = data.getLong(1);
        note.lastModification = data.getLong(2);
        note.title = data.getString(3);
        note.content = data.getString(4);
        note.archived = data.getString(5);
        note.trashed = data.getString(6);
        note.alarm = data.getString(7);
        note.latitude = data.getString(8);
        note.longitude = data.getString(9);
        note.address = data.getString(10);
        note.locked = data.getString(11);
        note.checklist = data.getString(12);
        note.category = new Category(data.getInt(13),data.getString(14),data.getString(15),data.getString(16));

        return note;
    }
}
