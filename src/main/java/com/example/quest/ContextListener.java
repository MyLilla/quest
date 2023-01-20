package com.example.quest;

import com.example.quest.dates.UserRepository;
import com.example.quest.services.AIContent;
import com.example.quest.services.QuestService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        AIContent aiContent = new AIContent();
        QuestService questService = new QuestService(aiContent);
        context.setAttribute("questName", questService);

        UserRepository userRepository = new UserRepository();
        context.setAttribute("userRepository", userRepository);
    }
}
