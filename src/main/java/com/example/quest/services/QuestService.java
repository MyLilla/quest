package com.example.quest.services;

import com.example.quest.dates.Level;
import com.example.quest.dates.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuestService {
    private static final Logger LOGGER = LogManager.getLogger(QuestService.class);
    public QuestList questContent = new QuestList();

    public User getNextLevel (User user) {

       if (user.getLevel() == null) {
           user.setLevel(questContent.getLevelsList().get(1));
           LOGGER.info("User's {} level was null. Added first level", user);
           return user;
       }
       if (user.getLevel().getId() == questContent.getLevelsList().size() - 2){

           user.setLevel(questContent.getLevelsList().get(1));
           LOGGER.info("User's {} level was final level. Added first level.", user);

           user.setWin(true);
           LOGGER.info("User {} is win", user);
           return user;
       }
        Level nextLevel = user.getLevel().getNextLevel();
        user.setLevel(nextLevel);
        LOGGER.info("User {} get next level: {}", user, nextLevel);
        return user;
    }
}
