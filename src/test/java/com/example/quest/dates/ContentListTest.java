package com.example.quest.dates;

import com.example.quest.services.AIContent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContentListTest {

    AIContent aiContent;

    @Test
    void createLevelsList() {
        aiContent = new AIContent();
        assertEquals(ContentList.class, aiContent.getClass().getSuperclass());
    }
}
