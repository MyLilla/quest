package com.example.quest.services;

import com.example.quest.dates.Level;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class QuestList {

    private static final Logger LOGGER = LogManager.getLogger(QuestList.class);
    @Getter
    private final List<Level> levelsList;

    public QuestList() {
        this.levelsList = createLevelsList();
        LOGGER.info("Created new levelsList");
    }

    public void addNewLevel (Level level) {
        int place = this.levelsList.size() -1;
        this.levelsList.add(place, level);
    }

    private List<Level> createLevelsList() {

        Level level0 = new Level(0, "Старт");
        Level level1 = new Level(1, "Ты узнал о сбежавшем Разуме. Он копирует себя очень быстро..",
                "Отключиться от интернета",
                "Пойти заварить чаю и подумать, чем это грозит",
                " пока ты шел, Разум подключился к твоему електрогрилю и схег кухню");
        Level level2 = new Level(2, "В мире начинается паника, Разум попал во все системы и пытается уничтожить людей",
                "Подождать",
                "Включить интернет, чтоб позвонить друзьям",
                "Разум добрался до твоего электровеника и вместо него теперь ты сидишь в кладовке");
        Level level3 = new Level(3, "Кто-то смог отключить электростанции в твоем городе",
                "Уйти подальше от города", "Подождать еще, попить чайку холодненокого, расслабиться",
                "Разум смог восстановить электричество и заставлял тебя смотреть сериал Клон 128 раз");
        Level level4 = new Level(4, "Победа");

        List<Level> levels = new ArrayList<>();

        levels.add(0, level0);
        levels.add(1, level1);
        levels.add(2, level2);
        levels.add(3, level3);
        levels.add(4, level4);
        LOGGER.info("Created level's card: {}", levels);

        for (int i = 1; i < levels.size() - 2; i++) {
            levels.get(i).setNextLevel(levels.get(i + 1));  // уставнавливет ссылку на следующий
        }
        return levels;
    }
}
