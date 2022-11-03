package com.example.quest.servlets;

import com.example.quest.dates.User;
import com.example.quest.services.QuestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(LogicServlet.class);
    public final QuestService QuestService = new QuestService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        LOGGER.info("New request: {} from: {}", request, user);

        User newUser = QuestService.getNextLevel(user);
        LOGGER.info("Update user {}, to newUser with level: {}", user, newUser.getLevel());
        request.getSession().setAttribute("user", newUser);

        if (newUser.isWin()) {
            LOGGER.info("User: {} is winner", user);
            response.sendRedirect("/finish");
        } else {

            request.setAttribute("isReady", "true");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
