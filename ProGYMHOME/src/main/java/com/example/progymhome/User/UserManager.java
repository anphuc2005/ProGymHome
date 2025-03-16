package com.example.progymhome.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
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
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateJson())
                .create();

        String temp = gson.toJson(users);
        System.out.println(temp);
    }
    public void saveToFile(String fileName) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateJson())
                .create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(users, writer);
            System.out.println("Dữ liệu đã được lưu vào file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateJson())
                .create();
        try (FileReader reader = new FileReader(fileName)) {
            Type userListType = new TypeToken<ArrayList<UserDetail>>(){}.getType();
            users = gson.fromJson(reader, userListType);
            System.out.println("Dữ liệu đã được tải từ file " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(UserDetail updatedUser, String fileName) {
        loadFromFile("src/main/java/com/example/progymhome/User/userData.json");
        for (UserDetail user : users) {
            if (user.getUsername().equals(updatedUser.getUsername())) {
                user.setName(updatedUser.getName());
                user.setDateOfBirth(updatedUser.getDateOfBirth());
                user.setWeight(updatedUser.getWeight());
                user.setHeight(updatedUser.getHeight());
                user.setWeightUnit(updatedUser.getWeightUnit());
                user.setHeightUnit(updatedUser.getHeightUnit());
                user.setAge(updatedUser.getAge());
                break;
            }
        }
        saveToFile(fileName);
    }
    public UserDetail findUser(String userName)
    {
        loadFromFile("src/main/java/com/example/progymhome/User/userData.json");
        for (UserDetail user : users)
        {
            if(user.getUsername().equals(userName)) return user;
        }
        return null;
    }
    public boolean checkUserOnList(String username, String password) {
        loadFromFile("src/main/java/com/example/progymhome/User/userData.json");
        for (UserDetail user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
