package com.bridgelabz.simpleservlet;

import com.bridgelabz.simpleservlet.utility.URegex;
import com.bridgelabz.simpleservlet.utility.UValidation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet", "/Login"},
        initParams = {
            @WebInitParam(name = "user", value = "Afzal"),
            @WebInitParam(name = "password", value = "Admin@12")
        }
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String userId = getServletConfig().getInitParameter("user");
        String userPassword = getServletConfig().getInitParameter("password");
        UValidation validationObject = new UValidation();

        if (validationObject.isValid(user, URegex.USER) && validationObject.isValid(password, URegex.PASSWORD)) {
            if (userId.equals(user) && userPassword.equals(password)) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Either user name or password is incorrect</font>");
                out.flush();
                requestDispatcher.include(request, response);
            }
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either user name or password is invalid</font>");
            out.flush();
            requestDispatcher.include(request, response);
        }
    }

}
