package com.example.android.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {
    private String name;
    private String surname;
    private int age;
    private String eMail;

    public Account(String name, String surname, int age, String eMail) {
        setName(name);
        setSurname(surname);
        setAge(age);
        seteMail(eMail);
    }

    public Account(Parcel in) {
    }

    public Account() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeInt(age);
        dest.writeString(eMail);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };
}
