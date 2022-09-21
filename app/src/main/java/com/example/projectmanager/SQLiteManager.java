package com.example.projectmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteManager extends SQLiteOpenHelper {

    public static SQLiteManager sqLiteManager;

    public static final String DBNAME = "Project.db";
    public static final int DBVERSION = 1;
    public static final String TABLENAME = "Project";
    public static final String COUNTER = "Counter";

    public static final String idfield = "id";
    public static final String titlefield = "title";
    public static final String descfield = "description";
    public static final String subjectfield = "subject";
    public static final String duedatefield = "duedate";

    public SQLiteManager(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    public static SQLiteManager instanceofDB(Context context){
        if(sqLiteManager == null)
            sqLiteManager = new SQLiteManager(context);

        return sqLiteManager;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*
        StringBuilder sql;
//CREATE TABLE tablename (counter INTEGER PRIMARY KEY AUTOINCREMENT, idfield INT, titlefield TEXT, descfield TEXT, subjectfiled TEXT, duedatefield TEXT)

        sql = new StringBuilder()
                .append("CREATE TABLE ")
                .append(TABLENAME)
                .append("(")
                .append(COUNTER)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(idfield)
                .append(" INT,")
                .append(titlefield)
                .append(" TEXT, ")
                .append(descfield)
                .append(" TEXT, ")
                .append(subjectfield)
                .append(" TEXT, ")
                .append(duedatefield)
                .append(" TEXT) ");

         */

        sqLiteDatabase.execSQL("create table Projects(id INT primary key autoincrement, title TEXT, description TEXT, subject TEXT, duedate TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        /*
        switch(oldversion){
            case 1:
                sqLiteDatabase.execSQL("ALTER TABLE " + tablename + "ADD COLUMN" + NEW_COLUMN + "TEXT");

            case 2:
                sqLiteDatabase.execSQL("ALTER TABLE " + tablename + "ADD COLUMN" + NEW_COLUMN + "TEXT");
        }
         */
    }

    public void addProjectToDatabase(project proj){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(idfield, proj.getId());
        contentValues.put(titlefield, proj.getTitle());
        contentValues.put(descfield, proj.getDescription());
        contentValues.put(subjectfield, proj.getSubject());
        contentValues.put(duedatefield, proj.getDuedate());

        sqLiteDatabase.insert(TABLENAME, null, contentValues);
    }

    public void populateProjectListArray(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM Project.db", null)) {
            if(result.getCount() != 0){
                while (result.moveToNext()){
                    int id = result.getInt(1);
                    String title = result.getString(2);
                    String desc = result.getString(3);
                    String subject = result.getString(4);
                    String duedate = result.getString(5);

                    project p = new project (id, title, desc, subject, duedate);

                    project.projectArrayList.add(p);
                }
            }
        }
    }

    public void updateProjectinDB(project p){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(idfield, p.getId());
        contentValues.put(titlefield, p.getTitle());
        contentValues.put(descfield, p.getDescription());
        contentValues.put(subjectfield, p.getSubject());
        contentValues.put(duedatefield, p.getDuedate());

        sqLiteDatabase.update(TABLENAME, contentValues, idfield + "=?", new String[]{String.valueOf(p.getId())});
    }
}
