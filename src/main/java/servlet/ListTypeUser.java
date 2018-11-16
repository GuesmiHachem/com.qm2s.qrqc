/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ServiceTypeUser;

/**
 *
 * @author Hachem
 */
public class ListTypeUser extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/listTypeUser.jsp";

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

        //--------------------------------------------------------
        String nameTypeUser = request.getParameter("nameTypeUser");
        String idTypeUser = request.getParameter("idTypeProblem");
        //--------------------------------------------------------
        String addTypeUser = request.getParameter("addTypeUser");
        String deleteTypeUser = request.getParameter("deleteTypeUser");
        String destroyAll = request.getParameter("destroyAll");

        //--------------------------------------------------------
        if (addTypeUser != null) {
            entity.TypeUser typeUser = new entity.TypeUser();
            typeUser.setName(nameTypeUser);
            ServiceTypeUser.create(typeUser);
        }

        //--------------------------------------------------------
        if (deleteTypeUser != null) {
            ServiceTypeUser.destroy(Integer.parseInt(idTypeUser));
        }
        //--------------------------------------------------------

        //--------------------------------------------------------
        if (destroyAll != null) {
            ServiceTypeUser.destroyAll();
        }

        response.sendRedirect(application.getContextPath() + "/ListTypeUser");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
