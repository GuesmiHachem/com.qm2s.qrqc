/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import java.io.IOException;
import java.util.List;
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
public class ListNotification extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/listNotification.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        application.getRequestDispatcher(pageweb).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();

        String removeAll = request.getParameter("removeAll");
        
        if (removeAll != null) {
            entity.User userPage = (entity.User) session.getAttribute("user");
            List<entity.Notification> listNotification = ServiceNotification.findAll();
            for (entity.Notification notification : listNotification) {

                entity.User u = ServiceUser.find(notification.getIdUser().getId());
                entity.Problem problem = ServiceProblem.find(notification.getIdProblem().getId());
                if (u.getId() == userPage.getId()) {
                     ServiceNotification.destroy(notification.getId());
                }
            }

        }
        response.sendRedirect(application.getContextPath() + "/ListNotification");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
