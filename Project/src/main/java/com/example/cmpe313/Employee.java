package com.example.cmpe313;

public class Employee {
    String name, surname, email, phoneNumber, salary;
    String promotion = "0";

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public Employee(String name, String surname, String salary, String phoneNumber, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "" + name + " " + surname + " " + salary + " " + phoneNumber + " " + email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
