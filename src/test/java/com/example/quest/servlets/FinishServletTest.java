package com.example.quest.servlets;

import com.example.quest.dates.User;
import com.example.quest.dates.UserRepository;
import org.junit.jupiter.api.AfterEach;
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
class FinishServletTest {
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
    UserRepository userRepository;


    @Mock
    User user;

    FinishServlet finishServlet;

    @BeforeEach
    void setup() throws ServletException {
        when(servletConfig.getServletContext())
                .thenReturn(context);

        when(request.getSession()).thenReturn(session);

        when(context.getAttribute("userRepository"))
                .thenReturn(userRepository);

        when(session.getAttribute("user")).thenReturn(user);

        finishServlet = new FinishServlet();
        finishServlet.init(servletConfig);

        when(context.getRequestDispatcher(eq("/WEB-INF/index.jsp")))
                .thenReturn(requestDispatcher);

    }

    @Test
    void doGetTest_WhenUserIsWin() throws ServletException, IOException {
        when(user.isWin()).thenReturn(true);

        finishServlet.doGet(request, response);

        verify(request, times(1))
                .setAttribute("win", true);

    }

    @Test
    void doGetTest_WhenUserIsNotWin() throws ServletException, IOException {
        when(user.isWin()).thenReturn(false);
        when(userRepository.getFailText(user)).thenReturn("failText");
        finishServlet.doGet(request, response);

        verify(request, times(1))
                .setAttribute("win", false);

        verify(request, times(1))
                .setAttribute("failText", "failText");
    }

    @AfterEach
    void ended() throws ServletException, IOException {

        verify(userRepository, times(1))
                .resetUserProgress(user);

        verify(session, times(1))
                .setAttribute("user", user);

        verify(request, times(1))
                .setAttribute("isFinished", true);

        verify(requestDispatcher, times(1))
                .forward(request, response);
    }
}
