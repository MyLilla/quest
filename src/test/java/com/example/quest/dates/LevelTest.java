package com.example.quest.dates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LevelTest {

    @Mock
    Level nextLevel;
    Level level;


    @BeforeEach
    void setup() {
        level = new Level(0, "question", "positiveText",
                nextLevel, "negativeText", "failText");
    }

    @Test
    void getIdTest() {
        assertEquals(0, level.getId());
    }

    @Test
    void getQuestionTest() {
        assertEquals("question", level.getQuestion());
    }

    @Test
    void getPositiveTextTest() {
        assertEquals("positiveText", level.getPositiveText());
    }

    @Test
    void getNextLevelTest() {
        assertEquals(nextLevel, level.getNextLevel());
    }

    @Test
    void getNegativeTextTest() {
        assertEquals("negativeText", level.getNegativeText());
    }

    @Test
    void getFailTextTest() {
        assertEquals("failText", level.getFailText());
    }

    @Test
    void setIdTest() {
        level.setId(1);
        assertEquals(1, level.getId());
    }

    @Test
    void setQuestionTest() {
        level.setQuestion("question 2");
        assertEquals("question 2", level.getQuestion());
    }

    @Test
    void setPositiveTextTest() {
        level.setPositiveText("positiveText 2");
        assertEquals("positiveText 2", level.getPositiveText());
    }

    @Mock
    Level setLevel;

    @Test
    void setNextLevelTest() {
        level.setNextLevel(setLevel);
        assertEquals(setLevel, level.getNextLevel());
    }

    @Test
    void setNegativeTextTest() {
        level.setNegativeText("negativeText 2");
        assertEquals("negativeText 2", level.getNegativeText());
    }

    @Test
    void setFailTextTest() {
        level.setFailText("failText 2");
        assertEquals("failText 2", level.getFailText());
    }
}
