package com.example.quest.servlets;

import com.example.quest.dates.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "FinishServlet", value = "/finish")
public class FinishServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        request.setAttribute("isReady", false);
        request.setAttribute("isFail", true);

        user.setLevel(null);
        user.setFail(false);
        user.setWinner(false);
        request.getSession().setAttribute("user", user);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
