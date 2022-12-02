package com.example.quest.servlets;

import com.example.quest.dates.User;
import com.example.quest.dates.UserRepository;
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
class InitServletTest {

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

    InitServlet initServlet;
    User user;

    @BeforeEach
    void setup() throws ServletException {
        when(servletConfig.getServletContext())
                .thenReturn(context);

        when(request.getSession(true))
                .thenReturn(session);

        when(context.getAttribute("userRepository"))
                .thenReturn(userRepository);

        initServlet = new InitServlet();
        initServlet.init(servletConfig);
        user = new User();

    }

    @Test
    void doGetTest() throws ServletException, IOException {

        when(request.getParameter("name"))
                .thenReturn("Name");
        when(context.getRequestDispatcher(eq("/WEB-INF/index.jsp")))
                .thenReturn(requestDispatcher);
        when(userRepository.getActualUser("Name"))
                .thenReturn(user);

        initServlet.doGet(request, response);

        verify(request, times(1))
                .setAttribute("isReady", false);
        verify(userRepository, times(1))
                .getActualUser("Name");

        verify(requestDispatcher, times(1))
                .forward(request, response);
    }
}
