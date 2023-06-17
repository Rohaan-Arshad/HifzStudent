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

    private static final String DATABASE_NAME = "Students.db";
    private static final String TABLE_NAME = "student";
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
                + COLUMN_ROLLNO + " TEXT PRIMARY KEY, "
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

    public int insertStudent(Student student, Record record) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values1 = new ContentValues();
        values1.put(COLUMN_NAME, student.getName());
        values1.put(COLUMN_ROLLNO, student.getRollNo());
        values1.put(COLUMN_AGE, student.getAge());
        values1.put(COLUMN_CLASS, student.getClas());

        long result1 = db.insert(TABLE_NAME, null, values1);

        ContentValues values2 = new ContentValues();
        values2.put(COLUMN_ROLLNO, student.getRollNo());
        values2.put(COLUMN_SABAQ_SURAH, record.getSabaq_surah());
        values2.put(COLUMN_SABAQ_TOTAL_AYAT, record.getSabaq_ayat());
        values2.put(COLUMN_PARA_SABAQ, record.getSabaq_parah());
        values2.put(COLUMN_SABQI_PARAH, record.getSabqi_parah());
        values2.put(COLUMN_MANZIL_PARAH, record.getManzil_parah());
        values2.put(COLUMN_DATE, record.getDate());

        long result2 = db.insert(TABLE_NAME1, null, values2);

        db.close();
        if (result1 == -1 || result2 == -1) {
            return -1;
        } else {
            return 1;
        }
    }
    public boolean isIdExists(String rollNo) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ROLLNO + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{rollNo});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }

    public int insertRecord_ID(Record record) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_ROLLNO, record.getRollNo());
        values.put(COLUMN_SABAQ_SURAH, record.getSabaq_surah());
        values.put(COLUMN_SABAQ_TOTAL_AYAT, record.getSabaq_ayat());
        values.put(COLUMN_PARA_SABAQ, record.getSabaq_parah());
        values.put(COLUMN_SABQI_PARAH, record.getSabqi_parah());
        values.put(COLUMN_MANZIL_PARAH, record.getManzil_parah());
        values.put(COLUMN_DATE, record.getDate());

        long result = db.insert(TABLE_NAME1, null, values);

        db.close();
        if (result == -1) {
            return -1;
        } else {
            return 1;
        }
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> studentList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        int rollNoIndex = cursor.getColumnIndex(COLUMN_ROLLNO);
        int nameIndex = cursor.getColumnIndex(COLUMN_NAME);
        int ageIndex = cursor.getColumnIndex(COLUMN_AGE);
        int classIndex = cursor.getColumnIndex(COLUMN_CLASS);

        while (cursor.moveToNext()) {
            String rollNo = cursor.getString(rollNoIndex);
            String name = cursor.getString(nameIndex);
            int age = cursor.getInt(ageIndex);
            String className = cursor.getString(classIndex);

            Student student = new Student(rollNo, name, age, className);
            studentList.add(student);
        }

        cursor.close();
        return studentList;
    }

    public ArrayList<Record>getRecords(String no)
    {
        ArrayList<Record> recordList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME1 + " WHERE " + COLUMN_ROLLNO + " = '" + no + "'";
        Cursor cursor = db.rawQuery(query,null);

        int rollno =  cursor.getColumnIndex(COLUMN_ROLLNO);
        int ss =  cursor.getColumnIndex(COLUMN_SABAQ_SURAH);
        int sta =  cursor.getColumnIndex(COLUMN_SABAQ_TOTAL_AYAT);
        int ps =  cursor.getColumnIndex(COLUMN_PARA_SABAQ);
        int sp =  cursor.getColumnIndex(COLUMN_SABQI_PARAH);
        int mp =  cursor.getColumnIndex(COLUMN_MANZIL_PARAH);
        int d =  cursor.getColumnIndex(COLUMN_DATE);

        while (cursor.moveToNext()) {
            String ro = cursor.getString(rollno);
            String sura_s = cursor.getString(ss);
            int sabaq_total_ayat = cursor.getInt(sta);
            int para_sbq = cursor.getInt(ps);
            int  sbqi_para= cursor.getInt(sp);
            int mnzil_para = cursor.getInt(mp);
            String dt = cursor.getString(d);

            Record student = new Record(ro, sura_s, sabaq_total_ayat, para_sbq, sbqi_para,mnzil_para , dt);
            recordList.add(student);
        }
        cursor.close();
        return recordList;
    }

}
