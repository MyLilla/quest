package com.example.quest.dates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Mock
    Level level;

    User user;

    @BeforeEach
    void setup() {
    user = new User("name", level, false, 0);
    }

    @Test
    void getNameTest() {
        assertEquals("name", user.getName());
    }

    @Test
    void getLevelTest() {
        assertEquals(level, user.getLevel());
    }

    @Test
    void isWinTest() {
        assertFalse(user.isWin());
    }

    @Test
    void getCountGamesTest() {
        assertEquals(0, user.getCountGames());
    }

    @Test
    void setNameTest() {
        user.setName("otherName");
        assertEquals("otherName", user.getName());
    }

    @Mock
    Level nextLevel;

    @Test
    void setLevelTest() {
        user.setLevel(nextLevel);
        assertEquals(nextLevel, user.getLevel());
    }

    @Test
    void setWinTest() {
        user.setWin(true);
        assertTrue(user.isWin());
    }

    @Test
    void setCountGamesTest() {
        user.setCountGames(1);
        assertEquals(1, user.getCountGames());
    }
}
