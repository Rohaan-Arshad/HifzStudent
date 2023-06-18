package com.example.hifzstudent;

public class Record {
    private String rollNo;
    private String sabaq_surah;
    private int sabaq_parah;
    private String sabaq_ayat;
    private int sabqi_parah;
    private int manzil_parah;
    private String date;

    public Record(String rollNo, String sabaq_surah, int sabaq_parah, String sabaq_ayat, int sabqi_parah, int manzil_parah, String date) {
        this.rollNo = rollNo;
        this.sabaq_surah = sabaq_surah;
        this.sabaq_parah = sabaq_parah;
        this.sabaq_ayat = sabaq_ayat;
        this.sabqi_parah = sabqi_parah;
        this.manzil_parah = manzil_parah;
        this.date = date;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getSabaq_surah() {
        return sabaq_surah;
    }

    public void setSabaq_surah(String sabaq_surah) {
        this.sabaq_surah = sabaq_surah;
    }

    public int getSabaq_parah() {
        return sabaq_parah;
    }

    public void setSabaq_parah(int sabaq_parah) {
        this.sabaq_parah = sabaq_parah;
    }

    public String getSabaq_ayat() {
        return sabaq_ayat;
    }

    public void setSabaq_ayat(String sabaq_ayat) {
        this.sabaq_ayat = sabaq_ayat;
    }

    public int getSabqi_parah() {
        return sabqi_parah;
    }

    public void setSabqi_parah(int sabqi_parah) {
        this.sabqi_parah = sabqi_parah;
    }

    public int getManzil_parah() {
        return manzil_parah;
    }

    public void setManzil_parah(int manzil_parah) {
        this.manzil_parah = manzil_parah;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
