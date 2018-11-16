/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hachem
 */
public class Logout extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/index.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        session.removeAttribute("user");
        session.removeAttribute("hardware");
        //session.invalidate();

        //application.getRequestDispatcher(pageweb).forward(request, response);
        response.sendRedirect(application.getContextPath());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();

        session.removeAttribute("user");
        //session.invalidate();
        application.getRequestDispatcher(pageweb).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
