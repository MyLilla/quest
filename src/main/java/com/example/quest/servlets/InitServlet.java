package com.example.quest.servlets;

import com.example.quest.dates.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.debug("InitServlet. Get request {}", request);

        HttpSession session = request.getSession(true);
        LOGGER.info("Save session {}", session.getId());

        User user = new User();
        user.setName(request.getParameter("name"));
        LOGGER.info("Create User: {}", user);

        session.setAttribute("user", user);
        request.setAttribute("isReady", false);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
