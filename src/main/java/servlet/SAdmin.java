/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Hardware;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ServiceHardware;

/**
 *
 * @author Hachem
 */
public class SAdmin extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/sadmin.jsp";

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

        String idHardware = request.getParameter("idHardware");
        String desactiver = request.getParameter("desactiver");
        String activer = request.getParameter("activer");
        String deleteHardware = request.getParameter("deleteHardware");
        String destroyAll = request.getParameter("destroyAll");
        Hardware hardware =null;
        if (idHardware != null) {
            hardware = ServiceHardware.find(Integer.parseInt(idHardware));
        }

        if (desactiver != null) {
            hardware.setActive(false);
            ServiceHardware.edit(hardware);
        }
        if (activer != null) {
            hardware.setActive(true);
            ServiceHardware.edit(hardware);
        }
        if (deleteHardware != null) {
            hardware.setActive(true);
            ServiceHardware.destroy(hardware.getId());
        }
        if (destroyAll != null) {
            ServiceHardware.destroyAll();
        }

        response.sendRedirect(application.getContextPath()+"/SAdmin");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
