package data;

import utils.PropertyReader;

public class Users {

    public static String EMAIL_ADDRESS = System.getProperty("EMAIL_ADDRESS", PropertyReader.getProperty("email"));
    public static String PASSWORD = System.getProperty("PASSWORD", PropertyReader.getProperty("password"));
}
