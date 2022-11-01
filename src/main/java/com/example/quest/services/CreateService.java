package com.example.quest.services;

import com.example.quest.dates.Level;
import lombok.Getter;

import java.util.*;

public class CreateService {

    @Getter
    private List <Level> levels;

    public CreateService() {
        this.levels = createLevels();
    }

    private List <Level> createLevels () {


        Level failLevel = new Level(0, "Провал");

        Level level1 = new Level(1, "Ты потерял память, принять вызов НЛО?",
                "Принять вызов", "Отклонить вызов");

        Level level2 = new Level(2, "Ты принял вызов, поднимишься на мостик к капитану?",
                "Подняться", "Отказаться");
        Level level3 = new Level(3, "Ты поднялся на мостик. Ты кто?",
                "Рассказать правду", "Соврать");
        Level level4 = new Level(4, "Победа");

        level4.setFailLevel(failLevel);

        List <Level> levels = new ArrayList<>();
        levels.add(0, failLevel);
        levels.add(1, level1);
        levels.add(2, level2);
        levels.add(3, level3);
        levels.add(4, level4);

        for (int i = 1; i < 4; i++) {
            levels.get(i).setNextLevel(levels.get(i + 1));  // уставнавливет ссылку на следующий
            levels.get(i).setFailLevel(levels.get(0));    // и на провал
        }
    return levels;
    }
}
