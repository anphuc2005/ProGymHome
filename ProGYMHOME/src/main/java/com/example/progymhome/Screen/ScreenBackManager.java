package com.example.progymhome.Screen;

import java.util.Stack;

public class ScreenBackManager {
    public static Stack<String> screenHistory = new Stack<>();

    public static void pushScreen(String fxml)
    {
        screenHistory.push(fxml);
    }

    public static String popScreen()
    {
        if(!screenHistory.isEmpty())
        {
            return screenHistory.pop();
        }
        return null;
    }
}
