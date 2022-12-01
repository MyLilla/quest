package com.example.quest.servlets;

import com.example.quest.dates.User;
import com.example.quest.dates.UserRepository;
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

@WebServlet(name = "FinishServlet", value = "/finish")
public class FinishServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(FinishServlet.class);
    UserRepository userRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        userRepository = (UserRepository) context.getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        LOGGER.info("New request: {} from user: {}", request, user);

        if (user.isWin()) {
            LOGGER.info("User {} is winner", user);
            user.setWin(false);
            request.setAttribute("win", true);
        } else {
            LOGGER.info("User {} loser", user);
            request.setAttribute("win", false);
            request.setAttribute("failText", userRepository.getFailText(user));
        }
        userRepository.resetUserProgress(user);
        LOGGER.info("Reset user's {} progress. New Level: {}. Count game = {}",
                user, user.getLevel(), user.getCountGames());

        request.getSession().setAttribute("user", user);
        request.setAttribute("isFinished", true);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
