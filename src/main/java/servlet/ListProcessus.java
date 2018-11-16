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
public class ListProcessus extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/listProcessus.jsp";

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

        String destroyAll = request.getParameter("destroyAll");
        String addProcessus = request.getParameter("addProcessus");
        String idProcessus = request.getParameter("idProcessus");
        String idNature = request.getParameter("idNature");
        String nameProcessus = request.getParameter("nameProcessus");
        String deleteProcessus = request.getParameter("deleteProcessus");
        String idUser = request.getParameter("idUser");

        //--------------------------------------------------------
        if (addProcessus != null) {
            entity.Nature nat = ServiceNature.find(Integer.parseInt(idNature));
            entity.User user = ServiceUser.find(Integer.parseInt(idUser));

            entity.Processus proc = new entity.Processus();
            proc.setName(nameProcessus);
            proc.setIdNature(nat);
            proc.setIdUser(user);

            ServiceProcessus.create(proc);
        }

        //--------------------------------------------------------
        if (destroyAll != null) {
            ServiceProcessus.destroyAll();
        }

        //--------------------------------------------------------
        if (deleteProcessus != null) {
            ServiceProcessus.destroy(Integer.parseInt(idProcessus));
        }
        response.sendRedirect(application.getContextPath() + "/ListProcessus");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
