package com.example.bookit;

public class FormData {

    String name,admin_Number,data,guardian_Name,phone_Number,guardian_Number;
    public FormData() { }
    public FormData(String name, String admin_Number, String data, String guardian_Name, String phone_Number, String guardian_Number) {
        this.name = name;
        this.admin_Number = admin_Number;
        this.data = data;
        this.guardian_Name = guardian_Name;
        this.phone_Number = phone_Number;
        this.guardian_Number = guardian_Number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdmin_Number() {
        return admin_Number;
    }

    public void setAdmin_Number(String admin_Number) {
        this.admin_Number = admin_Number;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGuardian_Name() {
        return guardian_Name;
    }

    public void setGuardian_Name(String guardian_Name) {
        this.guardian_Name = guardian_Name;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    public String getGuardian_Number() {
        return guardian_Number;
    }

    public void setGuardian_Number(String guardian_Number) {
        this.guardian_Number = guardian_Number;
    }
}