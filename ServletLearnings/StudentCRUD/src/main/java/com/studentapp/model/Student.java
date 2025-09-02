package com.studentapp.model;


public class Student {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;   // "Male", "Female", "Other"
    private String email;
    private String phone;
    private  String password ;

    // ✅ Constructors
    public Student() {}


    public Student(int id,int age ,String userName, String firstName, String lastName, String gender, String email, String phone, String password) {
        this.id = id;
        this.firstName = firstName;
        this.userName = userName;
        this.age = age;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ✅ Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    // ✅ toString()
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
