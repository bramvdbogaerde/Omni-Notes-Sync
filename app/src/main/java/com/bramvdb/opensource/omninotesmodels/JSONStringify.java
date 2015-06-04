package com.bramvdb.opensource.omninotesmodels;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by bramvandenbogaerde on 3/06/15.
 */
public class JSONStringify {
    public String toJSON() throws IllegalAccessException, JSONException {
        JSONObject object = new JSONObject();
        Object mThis = this;

        Field[] fields = this.getClass().getDeclaredFields();
        for(Field field : fields){
            if(Modifier.isPublic(field.getModifiers())){
                Log.v("com.bramvdb.debugger",field.getName());
                if(field.get(this) != null && field.get(this).toString() != null){
                        object.put(field.getName(),field.get(this).toString());
                }
            }
        }

        return object.toString();
    }
}
