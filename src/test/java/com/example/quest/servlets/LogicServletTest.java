package com.example.quest.servlets;

import com.example.quest.dates.QuestManager;
import com.example.quest.dates.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LogicServletTest {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;
    @Mock
    ServletConfig servletConfig;
    @Mock
    ServletContext context;
    @Mock
    RequestDispatcher requestDispatcher;
    @Mock
    QuestManager quest;

    LogicServlet logicServlet;
    @Mock
    User user;

    @BeforeEach
    void setup() throws ServletException {
        when(servletConfig.getServletContext())
                .thenReturn(context);

        when(context.getAttribute(eq("questName")))
                .thenReturn(quest);

        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("user")).thenReturn(user);

        logicServlet = new LogicServlet();
        logicServlet.init(servletConfig);

        when(session.getAttribute("user")).thenReturn(user);
        when(quest.startQuest(user)).thenReturn(user);
    }

    @Test
    void doGetTest() throws ServletException, IOException {

        when(user.isWin()).thenReturn(false);

        when(context.getRequestDispatcher(eq("/WEB-INF/index.jsp")))
                .thenReturn(requestDispatcher);

        logicServlet.doGet(request, response);

        verify(session, times(1))
                .setAttribute("user", user);

        verify(request, times(1))
                .setAttribute("isReady", "true");

        verify(requestDispatcher, times(1))
                .forward(request, response);
    }

    @Test
    void doGetTest_whenUserIsWin() throws ServletException, IOException {

        when(user.isWin()).thenReturn(true);
        when(request.getContextPath())
                .thenReturn("path");

        logicServlet.doGet(request, response);

        verify(response, times(1))
                .sendRedirect(eq("path/finish"));

    }
}
