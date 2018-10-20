package com.company;

public class Employee {
    private String name;
    private String surname;
    private String eMail;

    public Employee (String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public void setEmail (String eMail) {
        this.eMail = eMail.toLowerCase();
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }
}
