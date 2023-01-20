package com.example.quest.services;

import com.example.quest.dates.ContentList;
import com.example.quest.dates.Level;
import com.example.quest.exceptions.ReadingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AIContent extends ContentList {
    protected static final Logger LOGGER = LogManager.getLogger(AIContent.class);

    @Override
    protected List<Level> createLevelsList() {

        ObjectMapper mapper = new ObjectMapper();
        URL resource = AIContent.class.getClassLoader().getResource("content.json");

        try {
            List<Level> levels = mapper.readValue(resource, new TypeReference<ArrayList<Level>>() {
            });
            LOGGER.info("Created level's card: {}", levels);

            for (int i = 1; i < levels.size() - 2; i++) {
                levels.get(i).setNextLevel(levels.get(i + 1));
            }

            return levels;

        } catch (IOException e) {
            LOGGER.error("Reading content exception: {}", e.getMessage());
            throw new ReadingException("Reading content exception" + e);
        }
    }
}
