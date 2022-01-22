package com.example.cmpe313;

public class Exam {
    String examName;
    double gainedGrade = -1;
    double passGrade = -1;

    public Exam(String examName, double gainedGrade,double passGrade) {
        this.examName = examName;
        this.gainedGrade = gainedGrade;
        this.passGrade = passGrade;
    }

    public Exam(String examName,double passGrade) {
        this.examName = examName;
        this.passGrade = passGrade;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setGainedGrade(double gainedGrade) {
        this.gainedGrade = gainedGrade;
    }

    public void setPassGrade(double passGrade) {
        this.passGrade = passGrade;
    }

    public String getExamName() {
        return examName;
    }

    public double getGainedGrade() {
        return gainedGrade;
    }

    public double getPassGrade() {
        return passGrade;
    }
}
