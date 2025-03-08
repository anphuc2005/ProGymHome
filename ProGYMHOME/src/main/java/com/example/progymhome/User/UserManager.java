package com.example.progymhome.User;

import java.util.ArrayList;

public class UserManager {
    private static UserManager instance;
    private ArrayList<UserDetail> users;

    public UserManager()
    {
        this.users = new ArrayList<>();
    }
    public static UserManager getInstance()
    {
        if(instance == null)
        {
            instance = new UserManager();
        }
        return instance;
    }
    public void addUser (UserDetail user)
    {
        users.add(user);
    }

    public boolean checkUserOnList(String username, String password) {
        for (UserDetail user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
