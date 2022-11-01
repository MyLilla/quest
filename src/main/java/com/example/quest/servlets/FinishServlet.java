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

        if (user.isWin()){
            user.setWin(false);
            request.setAttribute("win", true);
        } else {
            request.setAttribute("win", false);
        }
            user.setLevel(null);
            request.getSession().setAttribute("user", user);
            request.setAttribute("isFinished", true);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

