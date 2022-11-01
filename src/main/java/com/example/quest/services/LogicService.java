package com.example.quest.services;

import com.example.quest.dates.Level;
import com.example.quest.dates.User;

public class LogicService {

    CreateService service = new CreateService();
    public User getNextLevel (User user) {

       if (user.getLevel() == null) {
           user.setLevel(service.getLevels().get(1));
           return user;
       }
       if (user.getLevel().getId() == 3){
           user.setLevel(service.getLevels().get(1));
           user.setWin(true);
           return user;
       }
        Level nextLevel = user.getLevel().getNextLevel();
        user.setLevel(nextLevel);
        return user;
    }


}
