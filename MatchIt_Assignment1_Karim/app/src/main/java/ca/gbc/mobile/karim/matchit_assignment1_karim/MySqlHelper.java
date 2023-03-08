package ca.gbc.mobile.karim.matchit_assignment1_karim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/***************************************************************************************************
 * KARIM KHOJA
 * 100874100
 * Created on October 12, 2014
 * Last Modified on October 24, 2014
 **************************************************************************************************/

public class MySqlHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "scores.db";
    public static final int DATABASE_VERSION = 2;

    //tables and columns
    public static final String TABLE_SCORES = "scores";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TIME = "time";

    //create statement
//    public static final String DATABASE_CREATE =
//            "create table "
//                    + TABLE_SCORES
//                    + "("+COLUMN_ID
//                    + " integer primary key autoincrement, "
//                    + COLUMN_NAME
//                    + " text, "
//                    + COLUMN_TIME
//                    + " text" + ")";

    public MySqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        Log.w(MySqlHelper.class.getName(),
//                "Create database " + DATABASE_NAME
//                        + " version " + DATABASE_VERSION);
        String DATABASE_CREATE =
                "create table "
                        + TABLE_SCORES
                        + "("+COLUMN_ID
                        + " integer primary key autoincrement, "
                        + COLUMN_NAME
                        + " text, "
                        + COLUMN_TIME
                        + " text" + ")";
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersionNo,
                          int newVersionNo) {
//
//        Log.w(MySqlHelper.class.getName(),
//                "Upgrade database from version "+oldVersionNo+
//                        " to version "+newVersionNo);
        //this should contain all changes that
        // you made in your database structure
        // starting from version 1 up

        db.execSQL("Drop table if exists " + TABLE_SCORES);
        onCreate(db);
    }

    public void addScore(Score score) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, score.getName());
        values.put(COLUMN_TIME, score.getTime());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_SCORES, null, values);
        db.close();
    }

    public Score selectScore(String pName) {
    String query = "Select * FROM " + TABLE_SCORES + " WHERE " + COLUMN_NAME + " =  \"" + pName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Score score = new Score();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            score.setId(Integer.parseInt(cursor.getString(0)));
            score.setName(cursor.getString(1));
            score.setTime(cursor.getString(2));
            cursor.close();
        } else {
            score = null;
        }
        db.close();
        return score;
    }

    public Score selectScore(int id) {
        String query = "Select * FROM " + TABLE_SCORES + " WHERE " + COLUMN_ID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Score score = new Score();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            score.setId(Integer.parseInt(cursor.getString(0)));
            score.setName(cursor.getString(1));
            score.setTime(cursor.getString(2));
            cursor.close();
        } else {
            score = null;
        }
        db.close();
        return score;
    }

    public List<Score> selectAllScores() {
        String query = "Select * FROM " + TABLE_SCORES + " ORDER BY " + COLUMN_TIME + " ASC";
        List<Score> allScores = new ArrayList<Score>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
//                cursor.moveToFirst();
                Score score = new Score();
                score.setId(Integer.parseInt(cursor.getString(0)));
                score.setName(cursor.getString(1));
                score.setTime(cursor.getString(2));
                allScores.add(score);
            } while (cursor.moveToNext());
        }
//        cursor.close();
//        db.close();
        return allScores;
//        db.close();
    }

    public boolean deleteProduct(int id) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_SCORES + " WHERE " + COLUMN_ID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Score product = new Score();

        if (cursor.moveToFirst()) {
            product.setId(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_SCORES, null, // COLUMN_ID + " = " + id,
                    new String[] { String.valueOf(product.getId()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public void deleteContact(Score contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SCORES, COLUMN_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
        db.close();
    }

    public int getScoresCount() {
        String countQuery = "SELECT  * FROM " + TABLE_SCORES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    public void deleteall(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SCORES, null, null);
        db.close();
    }
}

