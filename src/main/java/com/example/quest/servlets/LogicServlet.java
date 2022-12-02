package com.example.quest.servlets;

import com.example.quest.dates.User;
import com.example.quest.dates.QuestManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(LogicServlet.class);
    private QuestManager quest;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        quest = (QuestManager) context.getAttribute("questName");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        User user = (User) request.getSession().getAttribute("user");

        LOGGER.info("New request: {} from: {}", request, user);

        User newUser = quest.startQuest(user);
        LOGGER.info("Update user {}, to newUser with level: {}", user, newUser.getLevel());

        try {
            if (newUser.isWin()) {
                LOGGER.info("User: {} is winner", user);
                response.sendRedirect(request.getContextPath() + "/finish");
            } else {
                request.getSession().setAttribute("user", newUser);
                request.setAttribute("isReady", "true");
                getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
            }
        } catch (IOException e) {
            LOGGER.error("Redirect exception: {} request: {}", e.getMessage(), request);
            throw new ServletException("Error during redirect", e);
        }
    }
}
