package com.android.phuston.imgor.data;

import android.provider.BaseColumns;

/**
 * Created by patrick on 9/28/15.
 */
public class ImageContract {

    public ImageContract () {
    }

    public static abstract class ImageEntry implements BaseColumns {
        public static final String TABLE_NAME = "images";
        public static final String COLUMN_NAME_IMAGE = "image_entry";
    }
}
