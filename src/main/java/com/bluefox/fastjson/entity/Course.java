package com.bluefox.fastjson.entity;

public class Course {

    private String courseName;

    private Integer courseCode;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Course{\"courseName\":\""+courseName+"\",\"courseCode\":"+courseCode+"}";
    }
}
