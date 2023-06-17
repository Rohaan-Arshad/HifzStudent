package com.example.hifzstudent;

public class Student {
    private String rollNo;
    private String name;
    private int age;
    private String clas;

    public Student(String rollNo, String name, int age, String clas) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.clas = clas;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }
}