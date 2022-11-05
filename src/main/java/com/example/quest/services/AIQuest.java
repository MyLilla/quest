package com.example.quest.services;

import com.example.quest.dates.Level;
import com.example.quest.dates.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AIQuest implements QuestManager {
    private static final Logger LOGGER = LogManager.getLogger(AIQuest.class);
    private final AIContentList questContent;  // содержание контента зависит от того, что придет в конструкторе

    public AIQuest(AIContentList questContent) {
        this.questContent = questContent;
    }

    @Override
    public User playQuest(User user) {
        return getNextLevel(user);
    }

    public User getNextLevel(User user) {

        checkUser(user);

        if (user.getLevel() == null) {
            user.setLevel(questContent.getLevelsList().get(1));
            LOGGER.info("User's {} level was null. Added first level", user);
            return user;
        }
        if (user.getLevel().getId() == questContent.getLevelsList().size() - 2) {

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

    private void checkUser(User user) {
        if (user == null) {
            LOGGER.error("User is null");
            throw new RuntimeException("User is null");
        }
    }
}
