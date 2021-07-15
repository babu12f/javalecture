package com.eshikhon;

public final class MathTeacher extends Teacher {
    String mainSubject = "math";

    public String getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(String mainSubject) {
        this.mainSubject = mainSubject;
    }

    public void working() {
        System.out.println("teaching Math");
    }

    public void teaching() {
        System.out.println("Math teacher teaching math");
    }

    public void teachingCalculas() {
        System.out.println("teaching calculas");
    }
}
