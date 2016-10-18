package com.len.constellation.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.len.constellation.model.ConstellationLoveInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by Shaolei on 2016/10/17.
 */
public class ConstellationLoveImpl {
    private static final String path = "/data/data/com.len.constellation/files/moondata.db";
    private static ConstellationLoveImpl constellationLoveImpl;

    private ConstellationLoveImpl() {
    }

    public static ConstellationLoveImpl getIntance(Context context) {
        if (constellationLoveImpl == null) {
            constellationLoveImpl = new ConstellationLoveImpl();
            copyDbToSD(context);
        }
        return constellationLoveImpl;
    }

    public ConstellationLoveInfo findInfoById(String mid, String wid) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = db.query("constellaction_love", null, "mid = ? and wid = ?", new String[]{mid, wid}, null, null, null);
        ConstellationLoveInfo c = new ConstellationLoveInfo();
        while (cursor.moveToNext()) {
            c.setMid(cursor.getInt(cursor.getColumnIndex("mid")));
            c.setWid(cursor.getInt(cursor.getColumnIndex("wid")));
            c.setIndexnum(cursor.getInt(cursor.getColumnIndex("index_number")));
            c.setProportion(cursor.getString(cursor.getColumnIndex("proportion")));
            c.setContent(cursor.getString(cursor.getColumnIndex("content")));
        }
        cursor.close();
        db.close();
        return c;
    }

    private static void copyDbToSD(Context context){
        try {
            File file = new File(context.getFilesDir(), "moondata.db");
            if(!file.exists()){
                InputStream is = context.getAssets().open("moondata.db");
                FileOutputStream fos = new FileOutputStream(file);
                int len;
                byte[] buffer = new byte[1024];
                while((len = is.read(buffer)) != -1){
                    fos.write(buffer, 0, len);
                }
                fos.close();
                is.close();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
