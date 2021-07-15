package com.eshikhon;

public class EnglishTeacher extends Teacher {
    String mainSubject = "English";

    public String getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(String mainSubject) {
        this.mainSubject = mainSubject;
    }

    public void working() {
        System.out.println("teaching English");
    }

    public void teaching() {
        System.out.println("English teacher teaching english");
    }
}
