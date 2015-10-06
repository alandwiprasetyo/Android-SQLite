package com.sliding.root.sqliteandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by root on 06/10/15.
 */
public class StudentRepo {
    private DBHelper dbHelper;
    public StudentRepo(Context context){
        dbHelper = new DBHelper(context);
    }

    public int insert(Student student){
        SQLiteDatabase db = dbHelper.getWritableDatabase(); //Opening database connected
        ContentValues values = new ContentValues();
        values.put(Student.KEY_NAME,student.getName());
        values.put(Student.KEY_EMAIL,student.getEmail());
        values.put(Student.KEY_AGE,student.getAge());

        //Inserting Row
        long student_id = db.insert(Student.TABLE_NAME,null,values);
        db.close(); //Closing database connected
        return (int) student_id;
    }
    public void delete(int student_id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Student.TABLE_NAME,Student.KEY_ID + "= ?", new String[]{String.valueOf(student_id)});
        db.close();
    }
    public void update(Student student){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Student.KEY_NAME,student.getName());
        values.put(Student.KEY_EMAIL,student.getEmail());
        values.put(Student.KEY_AGE,student.getAge());

        //update
        db.update(Student.TABLE_NAME, values, Student.KEY_ID + "= ?", new String[]{String.valueOf(student.getId())});
        db.close();
    }
    public ArrayList<HashMap<String,String>> getStudentList(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM "+Student.TABLE_NAME;
        ArrayList<HashMap<String,String>> studentList = new ArrayList<HashMap<String, String>>();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                HashMap<String, String> student = new HashMap<String,String>();
                student.put("id",cursor.getString(cursor.getColumnIndex(Student.KEY_ID)));
                student.put("name",cursor.getString(cursor.getColumnIndex(Student.KEY_NAME)));
                studentList.add(student);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return studentList;
    }

    public Student getStudentbyId(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT * FROM "+Student.TABLE_NAME+" WHERE "+Student.KEY_ID+ "= ?";

        Student student = new Student();
        Cursor cursor =  db.rawQuery(query,new String [] {String.valueOf(id)});
        if(cursor.moveToFirst()){
            do {
                student.student_ID = cursor.getInt(cursor.getColumnIndex(Student.KEY_ID));
                student.name = cursor.getString(cursor.getColumnIndex(Student.KEY_NAME));
                student.email = cursor.getString(cursor.getColumnIndex(Student.KEY_EMAIL));
                student.age = cursor.getInt(cursor.getColumnIndex(Student.KEY_AGE));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();;
        return student;
    }


}
