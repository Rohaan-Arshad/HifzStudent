package com.example.hifzstudent;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";
    private static final String TABLE_NAME1 = "record";


    private static final String COLUMN_ROLLNO = "roll_no";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_CLASS = "class";
    private static final String COLUMN_SABAQ_SURAH = "sabaq_surah";
    private static final String COLUMN_SABAQ_TOTAL_AYAT = "sabaq_ayat";
    private static final String COLUMN_PARA_SABAQ = "para_sabaq";
    private static final String COLUMN_SABQI_PARAH = "sabqi_parah";
    private static final String COLUMN_MANZIL_PARAH = "manzil_parah";
    private static final String COLUMN_DATE = "date";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        String table1 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ROLLNO + " TEXT PRIMARY KEY "
                + COLUMN_NAME + " TEXT,"
                + COLUMN_AGE + " INTEGER,"
                + COLUMN_CLASS + " TEXT"
                + ")";
        db.execSQL(table1);

        String table2 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + "("
                + COLUMN_ROLLNO + " TEXT,"
                + COLUMN_SABAQ_SURAH + " TEXT,"
                + COLUMN_SABAQ_TOTAL_AYAT + " INTEGER,"
                + COLUMN_PARA_SABAQ + " INTEGER,"
                + COLUMN_SABQI_PARAH + " INTEGER,"
                + COLUMN_MANZIL_PARAH + " INTEGER,"
                + COLUMN_DATE + " TEXT,"
                + "FOREIGN KEY(" + COLUMN_ROLLNO + ") REFERENCES " + TABLE_NAME + "(" + COLUMN_ROLLNO + ")"
                + ")";
        db.execSQL(table2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql1 = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql1);

        String sql2 = "DROP TABLE IF EXISTS " + TABLE_NAME1;
        db.execSQL(sql2);

        onCreate(db);
    }

    public void insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_ROLLNO, student.getRollNo());
        values.put(COLUMN_ENROLL, student.isEnroll());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

//    public void updateStudent(Student student) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_NAME, student.getName());
//        values.put(COLUMN_ROLLNO, student.getRollNo());
//        values.put(COLUMN_ENROLL, student.isEnroll());
//
//        db.update(TABLE_NAME, values, COLUMN_ROLLNO + " = ?", new String[] {student.getRollNo()});
//        db.close();
//    }
//
//    public void deleteStudent(String rollNo) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_NAME, COLUMN_ROLLNO + " = ?", new String[] {rollNo});
//        db.close();
//    }


    public List<Student> selectAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {
                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());
        }
        * */

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range")  String rollNo = cursor.getString(cursor.getColumnIndex(COLUMN_ROLLNO));
                @SuppressLint("Range") boolean isEnroll = cursor.getInt(cursor.getColumnIndex(COLUMN_ENROLL))>0;
                students.add(new Student(name, rollNo, isEnroll));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return students;
    }
}
