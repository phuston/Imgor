package com.android.phuston.imgor.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by patrick on 9/29/15.
 */
public class ArrayHelper {
    Context mContext;
    ImageDbHelper mDbHelper;

    public ArrayHelper(Context context) {
        mContext = context;
        mDbHelper = new ImageDbHelper(context);
    }

    public void saveImage(String url){
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ImageContract.ImageEntry.COLUMN_NAME_IMAGE, url);

        long newRowId;
        newRowId = db.insert(
                ImageContract.ImageEntry.TABLE_NAME,
                ImageContract.ImageEntry.COLUMN_NAME_IMAGE,
                values
        );
    }

    public ArrayList<String> getSavedImages(){
        ArrayList<String> urls = new ArrayList<>();

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                ImageContract.ImageEntry.COLUMN_NAME_IMAGE
        };

        Cursor c = db.query(
                ImageContract.ImageEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        c.moveToFirst();
        while (c.moveToNext()) {
            urls.add(c.getString(c.getColumnIndexOrThrow(ImageContract.ImageEntry.COLUMN_NAME_IMAGE)));
        }

        return urls;
    }

}