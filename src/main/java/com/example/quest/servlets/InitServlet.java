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
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/init")
public class InitServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(InitServlet.class);
    UserRepository userRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        userRepository = (UserRepository) context.getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Get request {}", request);

        HttpSession session = request.getSession(true);
        LOGGER.info("Save session {}", session.getId());

        String name = request.getParameter("name");
        User user = userRepository.getActualUser(name);
        LOGGER.info("Create User: {} With name: {}", user, name);

        session.setAttribute("user", user);
        request.setAttribute("isReady", false);
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
