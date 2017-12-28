package TestingData;

import TestingData.Classes.User;

public class Users {

    public static User dir() {
        User user = new User();
        user.setFio("Иванов Иван Иванович");
        user.setShortFio("Иванов И.И.");
        user.setLogin("dir");
        user.setPwd("123");
        return  user;
    }

    public static User zamdir2() {
        User user = new User();
        user.setFio("Устинова Екатерина Семёновна");
        user.setShortFio("Устинова Е.С.");
        user.setLogin("zamdir2");
        user.setPwd("123");
        return  user;
    }

    public static User yurist() {
        User user = new User();
        user.setFio("Цветкова Алевтина Александровна");
        user.setShortFio("Цветкова А.А.");
        user.setLogin("yurist");
        user.setPwd("123");
        return  user;
    }

}
