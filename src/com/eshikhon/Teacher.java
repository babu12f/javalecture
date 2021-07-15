package com.eshikhon;

public abstract class Teacher {

    String designation = "lecturer";
    String collegeName = "dhaka";

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void working() {
        System.out.println("teaching");
    }

    abstract public void teaching();
}
