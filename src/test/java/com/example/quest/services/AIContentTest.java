package com.example.quest.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AIContentTest {
    @Mock
    AIContent aiContent;

    @Test
    void createLevelsListTest() {
        assertEquals(LinkedList.class,
                aiContent.createLevelsList().getClass());
    }
    @Test
    void createLevelsListTest_ThatListIsNotNull() {
        assertNotNull(aiContent.createLevelsList());
    }
}
