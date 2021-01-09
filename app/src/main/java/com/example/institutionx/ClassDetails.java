package com.example.institutionx;

public class ClassDetails {
    private String courseName;
    private String courseCode;
    private String courseTime;

    public ClassDetails(String courseName, String courseCode, String courseTime) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseTime = courseTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTime() {
        return courseTime;
    }
}
