package com.example.quest.dates;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    public static final Map<String, User> users = new HashMap<>();

    public User getActualUser (String name) {
        if (users.containsKey(name)){
            return users.get(name);
        } else {
            User user = new User();
            user.setName(name);
            return user;
        }
    }

    public void resetUserProgress(User user){
        user.setLevel(null);
        user.setCountGames(user.getCountGames() + 1);
    }

    public String getFailText (User user) {
        return user.getLevel().getFailText();
    }
}
