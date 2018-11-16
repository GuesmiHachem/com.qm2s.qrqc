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
import service.ServiceNature;

/**
 *
 * @author Hachem
 */
public class ListNature extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/listNature.jsp";

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
        String nameNature = request.getParameter("nameNature");
        String color = request.getParameter("color");
        String idNature = request.getParameter("idNature");
        //--------------------------------------------------------
        String addNature = request.getParameter("addNature");
        String deleteNature = request.getParameter("deleteNature");
        String destroyAll = request.getParameter("destroyAll");

        //--------------------------------------------------------
        if (addNature != null) {
            entity.Nature nature = new entity.Nature();
            nature.setName(nameNature);

            ServiceNature.create(nature);
        }

        //--------------------------------------------------------
        if (deleteNature != null) {
            ServiceNature.destroy(Integer.parseInt(idNature));
        }
        //--------------------------------------------------------

        //--------------------------------------------------------
        if (destroyAll != null) {
            ServiceNature.destroyAll();
        }

        response.sendRedirect(application.getContextPath() + "/ListNature");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
