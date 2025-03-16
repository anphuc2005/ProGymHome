package com.example.progymhome.User;

import java.util.ArrayList;

public class UserListSession {
    private static UserListSession instance;
    private ArrayList<UserSession> users;

    public UserListSession() {
        this.users = new ArrayList<>();
    }

    public static UserListSession getInstance()
    {
        if(instance == null)
        {
            instance = new UserListSession();
        }
        return instance;
    }
    public void addUserSession(UserSession userSession)
    {
        users.add(userSession);
    }

    public ArrayList<UserSession> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserSession> users) {
        this.users = users;
    }
}
