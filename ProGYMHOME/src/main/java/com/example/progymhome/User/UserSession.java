package com.example.progymhome.User;

public class UserSession {
    private String namePratice;
    private String detailPratice;
    private Integer repLesson;
    private Integer setLesson;
    private static UserSession instance;
    private UserSession() {}
    public static UserSession getInstance()
    {
        if(instance == null)
        {
            instance = new UserSession();
        }
        return instance;
    }
    public String getNamePratice() {
        return namePratice;
    }

    public void setNamePratice(String namePratice) {
        this.namePratice = namePratice;
    }

    public String getDetailPratice() {
        return detailPratice;
    }

    public void setDetailPratice(String detailPratice) {
        this.detailPratice = detailPratice;
    }



    public String[] splitString() {
        if (detailPratice != null && detailPratice.matches(".*\\S+\\s*[xX]\\s*\\S+.*")) {
            String[] parts = detailPratice.split("[xX]", 2);
            parts[0] = parts[0].trim();
            parts[1] = parts[1].trim();
            return parts;
        } else {
            return new String[] { detailPratice };
        }
    }
}
