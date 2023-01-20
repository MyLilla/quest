package com.example.quest.services;

import com.example.quest.dates.ContentList;
import com.example.quest.dates.Level;
import com.example.quest.dates.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestServiceTest {

    @Mock
    QuestService questService;
    @Mock
    ContentList questContent;
    @Mock
    Level level;
    @Mock
    List<Level> levelList;
    User user;

    @BeforeEach
    void setup() {
        questService = new QuestService(questContent);
        user = new User();
    }

    @Test
    void playQuestTest_whenUserIsNull() {
        assertThrows(RuntimeException.class,
                () -> questService.startQuest(null));
    }

    @Test
    void playQuestTest_whenUsersLevelIsNull() {
        user.setLevel(null);
        when(questContent.getLevelsList())
                .thenReturn(levelList);
        when(levelList.get(1)).thenReturn(level);

        questService.startQuest(user);

        assertEquals(user, questService.startQuest(user));
    }

    @Test
    void playQuestTest_whenUsersLevelIsFinal() {
        when(questContent.getLevelsList())
                .thenReturn(levelList);
        Level level1 = new Level();
        level1.setId(5);
        user.setLevel(level1);

        when(questContent.getLevelsList().size())
                .thenReturn(7);

        questService.startQuest(user);

        assertEquals(user.getLevel(),
                questContent.getLevelsList().get(1));

        assertTrue(user.isWin());
    }
}
