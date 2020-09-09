package com.nagaraj.f_evoting;

public class student1 {
    private String name;
    private String registration_no;
    private String password;


    public student1() {
    }

    public student1(String name, String registration_no, String password) {
        this.name = name;
        this.registration_no = registration_no;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration_no() {
        return registration_no;
    }

    public void setRegistration_no(String registration_no) {
        this.registration_no = registration_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
