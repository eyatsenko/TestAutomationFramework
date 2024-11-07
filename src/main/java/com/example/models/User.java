package com.example.models;

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
    private String state;
    private String city;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public User setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public User setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public User setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public User setSubjects(String[] subjects) {
        this.subjects = subjects;
        return this;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public User setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public User setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public User setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public String getState() {
        return state;
    }

    public User setState(String state) {
        this.state = state;
        return this;
    }

    public String getCity() {
        return city;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }
}
