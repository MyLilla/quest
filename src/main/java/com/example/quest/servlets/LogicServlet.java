package com.example.quest.servlets;

import com.example.quest.dates.Level;
import com.example.quest.dates.User;
import com.example.quest.services.LogicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {

    LogicService service = new LogicService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");
        User newUser = service.getNextLevel(user);

        if (newUser.isWin()) {
            response.sendRedirect("/finish");
        } else {

            request.getSession().setAttribute("user", newUser);
            request.setAttribute("isReady", "true");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}

