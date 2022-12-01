package com.example.quest.services;

import com.example.quest.dates.ContentList;
import com.example.quest.dates.Level;
import com.example.quest.dates.QuestManager;
import com.example.quest.dates.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuestService implements QuestManager {
    private static final Logger LOGGER = LogManager.getLogger(QuestService.class);
    private final ContentList questContent;

    public QuestService(ContentList questContent) {
        this.questContent = questContent;
        LOGGER.info("Create new quest with content: {}", questContent);
    }

    @Override
    public User startQuest(User user) {

        if (user == null) {
            LOGGER.error("User is null");
            throw new RuntimeException("User is null");
        }

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
}
