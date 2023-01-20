package com.example.quest;

import com.example.quest.dates.UserRepository;
import com.example.quest.services.AIContent;
import com.example.quest.services.QuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContextListenerTest {

    @Mock
    ServletContextEvent sce;
    @Mock
    ServletContext context;
    ContextListener contextListener;

    @BeforeEach
    void setup() {
        contextListener = new ContextListener();
    }

    @Test
    void contextInitializedTest() {
        when(sce.getServletContext())
                .thenReturn(context);

        contextListener.contextInitialized(sce);
    }
}
