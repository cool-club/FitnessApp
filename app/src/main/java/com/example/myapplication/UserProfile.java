package com.example.myapplication;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;


@ParseClassName("UserProfile")
public class UserProfile extends ParseObject {

    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_SELFIE = "selfie";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_CREATED_KEY = "createdAt";
    public static final String KEY_WEIGHT = "weight";
    public static final String KEY_AGE = "age";

    public String getDescription(){
        return getString(KEY_DESCRIPTION);

    }

    public void setDescription(String description){
        put(KEY_DESCRIPTION, description);

    }

    public static String getWeight() {
        return KEY_WEIGHT;
    }

    public void setWeight(String weight) {
        put(KEY_WEIGHT, weight);
    }

    public ParseFile getSelfie(){
        return getParseFile(KEY_SELFIE);

    }
    public void setImage(ParseFile parseFile){
        put(KEY_SELFIE, parseFile);
    }

    public ParseUser getUser(){
        return getParseUser(KEY_USERNAME);
    }

    public void setUser(ParseUser user){
        put(KEY_USERNAME, user);
    }


}
