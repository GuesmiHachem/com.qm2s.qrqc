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
public class Processus extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/processus.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        application = request.getServletContext();

        String idProcessus = request.getParameter("id");
        entity.Processus processus = ServiceProcessus.find(Integer.parseInt(idProcessus));
        //--------------------------------------------------------
        request.setAttribute("processus", processus);
        application.getRequestDispatcher(pageweb).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        session = request.getSession();
        application = request.getServletContext();
        //--------------------------------------------------------
        String idProcessus = request.getParameter("id");
        entity.Processus processus = ServiceProcessus.find(Integer.parseInt(idProcessus));
        //--------------------------------------------------------

        String nameProcessus = request.getParameter("nameProcessus");
        String idNature = request.getParameter("idNature");
        String idUser = request.getParameter("idUser");

        //--------------------------------------------------------
        String updateProcessus = request.getParameter("updateProcessus");
        //--------------------------------------------------------
        if (updateProcessus != null) {

            processus.setName(nameProcessus);
            processus.setIdNature(ServiceNature.find(Integer.parseInt(idNature)));
            processus.setIdUser(ServiceUser.find(Integer.parseInt(idUser)));
            ServiceProcessus.edit(processus);
        }
        response.sendRedirect(application.getContextPath() + "/Processus?id=" + processus.getId());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
