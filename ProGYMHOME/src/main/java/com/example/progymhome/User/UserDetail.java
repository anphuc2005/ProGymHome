package com.example.progymhome.User;

import java.time.LocalDate;

public class UserDetail {
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private double height;
    private double weight;
    private String weightUnit;
    private String heightUnit;
    private Integer age;
    private static UserDetail instance;
    private UserListSession userListSession;

    public static UserDetail getInstance()
    {
        if(instance == null)
        {
            instance = new UserDetail();
        }
        return instance;
    }
    public UserDetail()
    {
        this.userListSession = new UserListSession();
    }
    public String getName() {
        return name;
    }

    public UserListSession getUserListSession() {
        return userListSession;
    }

    public void setUserListSession(UserListSession userListSession) {
        this.userListSession = userListSession;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }

    public boolean isValidLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public boolean isValidDigit(String temp)
    {
        for (int i = 0 ; i < temp.length() ; ++i)
        {
            if(!Character.isDigit(temp.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

    public void changeWeightAndHeight ()
    {
        if(weightUnit == "Pound")
        {
            weight *= 0.45;
            weightUnit = "Kg";
        }
        if(heightUnit == "M")
        {
            height *= 100;
            heightUnit = "Cm";
        }
        else if(heightUnit == "feet")
        {
            height *= 30.48;
            heightUnit = "Cm";
        }
    }


}
