package com.sliding.root.sqliteandroid;

/**
 * Created by root on 06/10/15.
 */
public class Student {

    public static String TABLE_NAME = "student";
    public static String KEY_ID = "id";
    public static String KEY_NAME = "name";
    public static String KEY_EMAIL = "email";
    public static String KEY_AGE = "age";

    // property help us to keep data
    int student_ID;
    String name;
    String email;
    int age;

    public void setId(int id){
        student_ID = id;
    }
    public int getId(){
        return student_ID;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

}
