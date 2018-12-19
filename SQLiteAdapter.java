package com.example.shri.weight_and_watch;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

class SQLiteAdapter {

    private static final String DB_NAME = "DATABASE";
    private static final String USER_TABLE = "USER_TABLE";

    private static final String LOGIN_TABLE = "LOGIN_TABLE";


    private static final int DB_VERSION = 1;

    private static final String KEY_ID = "_id";
    private static final String USER_NAMES = "USER_NAMES";
    private static final String EMAIL = "EMAIL";
    private static final String PASSWORD = "PASSWORD";
    private static final String CONTACT_NUMBERS = "CONTACT_NUMBERS";


    //create table MY_DATABASE (ID integer primary key, Content text not null);
    private static final String SCRIPT_CREATE_DATABASE =
            "create table " + LOGIN_TABLE + " ("
                    + KEY_ID + " integer primary key autoincrement, "
                    + USER_NAMES + " text, "
                    + EMAIL + " text, "
                    + PASSWORD + " text, "
                    + CONTACT_NUMBERS + " text);";

    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;

    private Context context;

    SQLiteAdapter(Context c) {
        context = c;
    }

    private void openToRead() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, DB_NAME, null, DB_VERSION);
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();

    }

    private void openToWrite() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, DB_NAME, null, DB_VERSION);
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

    }

    private void close() {
        sqLiteHelper.close();
    }

    boolean insert(SQLiteAdapter sqLiteAdapter, String name, String email, String password, String number) {

        sqLiteAdapter.openToWrite();
        ContentValues contentValues = new ContentValues();

        contentValues.put(USER_NAMES,name);
        contentValues.put(EMAIL, email);
        contentValues.put(CONTACT_NUMBERS, number);
        contentValues.put(PASSWORD, password);
        sqLiteDatabase.insert(LOGIN_TABLE, null, contentValues);
        sqLiteAdapter.close();
        return true;
    }

    void deleteRow(SQLiteAdapter sqLiteAdapter, String id) {

        sqLiteAdapter.openToWrite();
        sqLiteDatabase.execSQL("delete from " + LOGIN_TABLE + " where _id='" + id + "'");
        sqLiteAdapter.close();


    }

    ArrayList<LoginModel> getAllRecords(SQLiteAdapter sqLiteAdapter) {

        sqLiteAdapter.openToRead();
        ArrayList<LoginModel> listItems = new ArrayList<>();

        String[] columns = new String[]{KEY_ID, USER_NAMES, EMAIL, PASSWORD,CONTACT_NUMBERS};
        Cursor cursor = sqLiteDatabase.query(LOGIN_TABLE, columns,
                null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                LoginModel loginModel = new LoginModel();
                loginModel.setContactNames(cursor.getString(cursor.getColumnIndex(USER_NAMES)));
                loginModel.setId(cursor.getString(cursor.getColumnIndex(KEY_ID)));
                loginModel.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
                loginModel.setPassword(cursor.getString(cursor.getColumnIndex(PASSWORD)));
                loginModel.setContactNumbers(cursor.getString(cursor.getColumnIndex(CONTACT_NUMBERS)));
                listItems.add(loginModel);
            } while (cursor.moveToNext());
        }

        cursor.close();

        sqLiteAdapter.close();

        return listItems;
    }


    public class SQLiteHelper extends SQLiteOpenHelper {

        SQLiteHelper(Context context, String name,
                     CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL(SCRIPT_CREATE_DATABASE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

        }


    }


}