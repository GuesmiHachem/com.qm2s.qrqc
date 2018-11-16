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
import service.*;

/**
 *
 * @author Hachem
 */
public class Notification extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    //public String pageweb = "/user/page/problem.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------
        String id = request.getParameter("id");

        entity.Notification not = ServiceNotification.find(Integer.parseInt(id));
        if (not == null) {
            response.sendRedirect(application.getContextPath() + "/ListNotification");
        } else {
            entity.Problem problem = not.getIdProblem();
            ServiceNotification.destroy(not.getId());
            response.sendRedirect(application.getContextPath() + "/Problem?id=" + problem.getId());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
