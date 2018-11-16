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
import entity.Level3;
import service.*;

/**
 *
 * @author Hachem
 */
public class Level extends HttpServlet {

    public HttpSession session = null;
    public ServletContext application = null;
    public String pageweb = "/user/page/level.jsp";

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
        String nameLevel = request.getParameter("nameLevel");
        String idLevel = request.getParameter("idLevel");
        //--------------------------------------------------------
        String addLevel = request.getParameter("addLevel");
        String deleteAll = request.getParameter("deleteAll");
        String deleteLevel = request.getParameter("deleteLevel");
        //--------------------------------------------------------
        if (addLevel != null) {
            Level3 level3 = new Level3();
            level3.setName(nameLevel);
            ServiceLevel3.create(level3);
        }
        //--------------------------------------------------------
        if (deleteAll != null) {
            ServiceLevel3.destroyAll();
        }
        //--------------------------------------------------------
        if (deleteLevel != null) {
            ServiceLevel3.destroy(Integer.parseInt(idLevel));
        }
        //--------------------------------------------------------
        response.sendRedirect(application.getContextPath() + "/Level");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
