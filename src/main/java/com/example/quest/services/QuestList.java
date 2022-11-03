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
    private static final int FINISH_LEVEL_ID = 4;
    private static final int START_LEVEL_ID = 0;

    public QuestList() {
        this.levelsList = createLevelsList();
        LOGGER.info("Created new levelsList: {}", this.levelsList);
    }

    private List<Level> createLevelsList() {

        List<Level> levels = new ArrayList<>();

        Level startLevel = new Level(START_LEVEL_ID);
        levels.add(START_LEVEL_ID, startLevel);

        Level level1 = new Level(1,
                "Ты узнал о сбежавшем Разуме. Он копирует себя очень быстро.. Что ты предпримешь?",
                "Отключусь от интернета",
                "Пойду заварю чаю и подумаю, чем это грозит",
                "пока ты пил чай, Разум подключился к твоему электрогрилю и сжег кухню");
        Level level2 = new Level(2,
                "В мире начинается паника, Разум попал во все системы и пытается уничтожить людей. Твои действия?",
                "Подождуь и посмотрю, что будет",
                "Включу телефон, и поспрашиваю у друзей",
                "через телефон Разум добрался до твоего электровеника и вместо него, теперь ты сидишь в кладовке");
        Level level3 = new Level(3,
                "Все электростанции отключены, что будешь делать дальше?",
                "Уйду подальше от города", "Подожду еще, попью чайку холодненького, расслабитлюсь",
                "пока ты сидел на диване, Разум смог восстановить электричество и заставлял тебя смотреть сериал Клон 128 раз");

        Level finishLevel = new Level(FINISH_LEVEL_ID);

        levels.add(1, level1);
        levels.add(2, level2);
        levels.add(3, level3);
        levels.add(FINISH_LEVEL_ID, finishLevel);
        LOGGER.info("Created level's card: {}", levels);

        for (int i = 1; i < levels.size() - 2; i++) {
            levels.get(i).setNextLevel(levels.get(i + 1));
        }
        return levels;
    }
}
