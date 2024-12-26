package com.example.models;

import lombok.Getter;

@Getter
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobileNumber;
    private String dateOfBirth;
    private String[] subjects;
    private String[] hobbies;
    private String picture;
    private String currentAddress;
    private String permanentAddress;
    private String state;
    private String city;
    private String username;
    private String password;
    private String salary;
    private String department;

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public User setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public User setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public User setSubjects(String[] subjects) {
        this.subjects = subjects;
        return this;
    }

    public User setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public User setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public User setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public User setState(String state) {
        this.state = state;
        return this;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }

    public User setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
        return this;
    }

    public User setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public User setDepartment(String department) {
        this.department = department;
        return this;
    }
}
