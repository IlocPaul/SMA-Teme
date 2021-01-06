package com.example.fitnessapp;

//we create an object which takes all the information about  a new user
//we will return this object in firebase
public class User {

    public String fullName, email,gender, height, weight;

    public User()
    {

    }

    public User(String fullName,String email, String gender, String height, String weight)
    {
        this.fullName=fullName;
        this.email=email;
        this.gender=gender;
        this.height=height;
        this.weight=weight;
    }
}
