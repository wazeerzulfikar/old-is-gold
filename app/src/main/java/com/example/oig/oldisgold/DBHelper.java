package com.example.oig.oldisgold;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zulfi on 15/06/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    public static final String DATABASE_NAME = "oldisgold.db";
    public static final String TABLE_CONTACTS = "emergency_contacts";
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NUMBER = "contactNo";


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CONTACTS = "CREATE TABLE "+TABLE_CONTACTS+"("+COLUMN_ID+" INTEGER PRIMARY KEY, "+COLUMN_NAME+ " TEXT, "+COLUMN_NUMBER
                +" INTEGER)";
        db.execSQL(CREATE_TABLE_CONTACTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACTS);
        onCreate(db);
    }

    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,contact.getName());
        values.put(COLUMN_NUMBER,contact.getPhone());

        long row_id = db.insert(TABLE_CONTACTS,null,values);
    }

    public List<Contact> getAllContacts(){
        List <Contact> contactList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+TABLE_CONTACTS;
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                contactList.add(new Contact(cursor.getString(1),cursor.getString(2));
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }
}
