package com.example.quest.dates;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
@Setter
@ToString
public class User {

    private static final Logger LOGGER = LogManager.getLogger(User.class);

    private String name;
    private Level level;
    boolean winner = false;
    boolean fail = false;

    public User() {
        LOGGER.info("User info test");
        LOGGER.error("User error test");
        LOGGER.debug("User debug test");
    }

}
