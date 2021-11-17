package com.bridgelabz.simpleservlet.utility;

public class URegex {
    public static final String USER = "^[A-Z]{1}[a-z]{2,}$";
    public static final String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
}
