package com.example.cmpe313;

public class Department {
    String name;
    String budgetOfDeparment;
    String numberOfEmployee;

    public Department(String name, String budgetOfDeparment, String numberOfEmployee) {
        this.name = name;
        this.budgetOfDeparment = budgetOfDeparment;
        this.numberOfEmployee = numberOfEmployee;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getBudgetOfDeparment() {
        return budgetOfDeparment;
    }

    public String getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudgetOfDeparment(String budgetOfDeparment) {
        this.budgetOfDeparment = budgetOfDeparment;
    }

    public void setNumberOfEmployee(String numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }
}
