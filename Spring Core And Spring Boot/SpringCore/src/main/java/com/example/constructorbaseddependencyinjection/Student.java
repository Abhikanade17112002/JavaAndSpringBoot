package com.example.constructorbaseddependencyinjection;

public class Student {
    private String firstName ;
    private String lastName ;
    private String gender ;
    private Course course ;

    public Student(String firstName, String lastName, String gender, Course course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", course=" + course +
                '}';
    }
}
